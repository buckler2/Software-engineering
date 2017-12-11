library(jsonlite)
library(httpuv)
library(httr)

oauth_endpoints("github")
myapp <- oauth_app(appname = "Software Engineering", key = "f7e905beb15f09442c4a",
                     secret = "03bef356950401e16edfd6f979f7c74e7087fb73")

gh_token <- oauth2.0_token(oauth_endpoints("github"), myapp)
token <- config(token = gh_token)

getrepo <- GET("https://api.github.com/users/buckler2/repos", token)

stop_for_status(request)
json1 = content(request)
gitDF = jsonlite::fromJSON(jsonlite::toJSON(json1))
