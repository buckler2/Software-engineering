library(jsonlite)
library(httpuv)
library(httr)


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

usernamesforWeeklyCommits = usernames[1:60]

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
alluserdata =c()
ownerdata = c()
i=0
languages =c()
#add number of commits per week to vector
#also find how much of the commits each week are from the owner of the repository
#find which code is used most by byte size
for(i in 1: length(userIdAndRepo))
{
  getWeeklyCommit =  content(GET(paste0("https://api.github.com/repos/",userIdAndRepo[i],"/stats/participation"), token))
  weeklyCommits = c(getWeeklyCommit$all)
  ownerWeeklyCommits = c(getWeeklyCommit$owner)
  ownerdata = c(ownerdata,ownerWeeklyCommits )
  alluserdata = c(alluserdata, weeklyCommits)
  getLanguages = content(GET(paste0("https://api.github.com/repos/",userIdAndRepo[i],"/languages"),token))
  languages = c(languages,getLanguages)
}
#create matrix
matrixData = matrix(alluserdata, nrow = 52, ncol = length(userIdAndRepo),byrow =TRUE)
ownerMatrix = matrix(ownerdata,nrow = 52, ncol = length(userIdAndRepo),byrow =TRUE)
#write data to excel
write.csv(matrixData, file = "allusercommits.csv",row.names = FALSE )
write.csv(ownerMatrix, file = "ownerWeeklyCommits.csv",row.names = FALSE )
write.csv(languages, file = "languages.csv",row.names=FALSE)
'I am going to use the excels files with plotly oline as you need plotly premium
to use directly in r'

library(plotly)
trace1 <- list(
  x = c("C", "PHP", "Go", "TypeScript", "Java", "Python", "HTML", "R", "Ruby", "Haskell", "Scala", "Bison", "Assemby", "Shell", "CSS"), 
  y = c("916562463", "237634933", "74265009", "65824304", "55905060", "50964391", "50057090", "35306117", "34844659", "31654610", "27998995", "21676388", "10760835", "12807125", "8994593"), 
  name = "Bites", 
  type = "bar", 
  uid = "488e1d", 
  xsrc = "buckler2:10:73fa41", 
  ysrc = "buckler2:10:25e2e5"
)
data <- list(trace1)
layout <- list(
  autosize = TRUE, 
  hovermode = "closest", 
  title = "Most used languages by bites in repositories", 
  xaxis = list(
    autorange = TRUE, 
    range = c(-0.5, 14.5), 
    title = "Most Used Languages", 
    type = "category"
  ), 
  yaxis = list(
    autorange = TRUE, 
    range = c(0, 964802592.632), 
    title = "Bites", 
    type = "linear"
  )
)
p <- plot_ly()
p <- add_trace(p, x=trace1$x, y=trace1$y, name=trace1$name, type=trace1$type, uid=trace1$uid, xsrc=trace1$xsrc, ysrc=trace1$ysrc)
p <- layout(p, autosize=layout$autosize, hovermode=layout$hovermode, title=layout$title, xaxis=layout$xaxis, yaxis=layout$yaxis)

'My data to create both time series was too big too include in this code, I used plotly to create the time series graphs
but the code for r wass too large, see images in github repository'

