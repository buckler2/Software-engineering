library(jsonlite)
library(httpuv)
library(httr)

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

# Subset data.frame
gitDF[gitDF$full_name == "buckler2/datasharing", "created_at"] 

#get info on phadej followers
nameState = c('phadej')
getProfile = content(GET("https://api.github.com/users/phadej", token))
followers_JSON = content(GET("https://api.github.com/users/phadej/followers", token))
phadejFollowers = jsonlite::fromJSON(jsonlite::toJSON(followers_JSON))
userNames = phadejFollowers$login
userNames

#get phadej follower's profile




