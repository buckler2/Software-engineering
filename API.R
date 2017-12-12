library(jsonlite)
library(httpuv)
library(httr)
library(reshape)
'initial set up taken from
https://towardsdatascience.com/accessing-data-from-github-api-using-r-3633fb62cb08'

oauth_endpoints("github")
app <- oauth_app(appname = "Software Engineering", key = "97c3d9beb438eadd730e",
                     secret = "201bb4ee8eb0618f9797d30acef5355553243e67")

gh_token <- oauth2.0_token(oauth_endpoints("github"),app)
token <- config(token = gh_token)

request <- GET("https://api.github.com/users/phadej", token)

#take on action httr error
stop_for_status(request)

#extraxt content from a request
json1 <- content(request)


#convert to a data frame
gitDF = jsonlite::fromJSON(jsonlite::toJSON(json1))

#get initial info on phadej followers
getProfile = content(GET("https://api.github.com/users/phadej", token))
followers_JS = content(GET("https://api.github.com/users/phadej/followers", token))
phadejFollowers = jsonlite::fromJSON(jsonlite::toJSON(followers_JS))
usernames = phadejFollowers$login
usertype = phadejFollowers$repos_url

#a dataframe containing user and all of their followers
userConnection = c()
phadej = c("phadej,")
#get phadej follower's profile
for(i in 1:length(usernames))
{
  #make connection
  userConnection = c(userConnection, paste0(phadej,usernames[i]))
}

#Get phadej's followers followers
for(i in 1: length(usernames))
{
  #retrieve profile
  userfollowersProfile_JS =content(GET(paste0("https://api.github.com/users/",usernames[i],"/followers"),token)) 
  userfollowersProfile_R = jsonlite::fromJSON(jsonlite::toJSON(userfollowersProfile_JS))
  theirUserNames = c(userfollowersProfile_R$login)
  #get follower names
  theirUserProfileNames =  c(userfollowersProfile_R$login)
  for(j in 1: length(theirUserProfileNames))
  {
    #make connection
    userConnection = c(userConnection, paste0(phadej,usernames[i],",", theirUserProfileNames[j]))
  }
}
#remove duplicates

#alter data so it fits into csv
userConnection = userConnection[31:685]

userConnection[1]
df <- data.frame(userConnection)
df = transform(df, userConnection = colsplit(userConnection, split = ",", names = c('root','ancestor1', 'ancestor2')))
userConnection = c(df)
write.csv(userConnection, file = "connection.csv", row.names = FALSE )
