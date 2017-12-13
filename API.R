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
token = config(token = gh_token)

request <- GET("https://api.github.com/users/phadej", token)

#take on action httr error
stop_for_status(request)

#extraxt content from a request
json1 <- content(request)

#convert to a data frame
gitDF = jsonlite::fromJSON(jsonlite::toJSON(json1))


#get initial info on phadej followers
phadej = content(GET("https://api.github.com/users/phadej", token))
followers_JS = content(GET("https://api.github.com/users/phadej/followers", token))
phadejFollowers = jsonlite::fromJSON(jsonlite::toJSON(followers_JS))
usernames = c("phadej")
usernames = c(usernames , phadejFollowers$login)
#a dataframe containing user and all of their followers
phadej = c("phadej,")
#get phadej follower's profile

#Get phadej's followers followers
for(i in 1: length(usernames))
{
  #retrieve profile
  userfollowersProfile_JS =content(GET(paste0("https://api.github.com/users/",usernames[i],"/followers"),token)) 
  userfollowersProfile_R = jsonlite::fromJSON(jsonlite::toJSON(userfollowersProfile_JS))
  theirUserNames = c(userfollowersProfile_R$login)
  #get follower names
  theirUserProfileNames =  c(userfollowersProfile_R$login)
  usernames = c(usernames,theirUserProfileNames)
}
#remove duplicates
usernames = unique(usernames)

'due to the length of time it takes to run this for loop I am going to reduce the amount of users
in order to get weekly commits. This will  still work for larger samples of data'

usernamesforWeeklyCommits = usernames[1:10]
#test
#create data frame to store users and their repos
userIdAndRepo = c()
#get username and repo name and fill into vector
for(i in 1:length(usernamesforWeeklyCommits))
{
  repo =  content(GET(paste0("https://api.github.com/users/", usernamesforWeeklyCommits[i], "/repos"), token))
  allrepos_R = jsonlite::fromJSON(jsonlite::toJSON(repo))
  names = c(allrepos_R$full_name)
  userIdAndRepo = c(userIdAndRepo , names)
}
#remove duplicates
userIdAndRepo = unique(userIdAndRepo)
x = length(userIdAndRepo)*52
x
data =c()
i=0
#add number of commits per week to vector
#also find how much of the commits each week are from the owner of the repository
for(i in 1: length(userIdAndRepo))
{
  getWeeklyCommit =  content(GET(paste0("https://api.github.com/repos/",userIdAndRepo[i],"/stats/participation"), token))
  weeklyCommits = c(getWeeklyCommit$all)
  data = c(data, weeklyCommits)
}
#create matrix
matrixData = matrix(data, nrow = 52, ncol = length(userIdAndRepo),byrow =TRUE)
matrixData
#write data to excel
write.csv((matrixData), file = "commits.csv",row.names = FALSE )


