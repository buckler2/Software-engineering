library(jsonlite)
library(httpuv)
library(httr)

oauth_endpoints("github")
myapp <- oauth_app(appname = "Software Engineering", key = "f7e905beb15f09442c4a",
                     secret = "03bef356950401e16edfd6f979f7c74e7087fb73")

gh_token <- oauth2.0_token(oauth_endpoints("github"), myapp)
token <- config(token = gh_token)

getrepo <- GET("https://api.github.com/users/buckler2/repos", token)



# Take action on http error
stop_for_status(req)

# Extract content from a request
json1 = content(req)

# Convert to a data.frame
gitDF = jsonlite::fromJSON(jsonlite::toJSON(json1))

# Subset data.frame
gitDF[gitDF$full_name == "sorchaobyrne/datasharing", "created_at"]
