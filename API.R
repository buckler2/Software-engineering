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
gitDF[gitDF$full_name == "jtleek/datasharing", "created_at"] 

#Interrogate Github to obtain phadej FOLLOWERS
phadFollowers = fromJSON("https://api.github.com/users/phadej/followers")

#Find usernames
followers = phadFollowers$login
