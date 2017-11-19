library(httr);

'Access token = 15050eb5dcf2a17e95252d709911e4f7a347929d'
'https://developer.github.com/v4/guides/intro-to-graphql/'

query <- "https://api.github.com/orgs/github";
query2 <- "https://api.github.com/users/octocat";
query3 <- "https://api.github.com/teams/1";

curl = "15050eb5dcf2a17e95252d709911e4f7a347929d https://api.github.com/graphql";
out = GET(url = curl);

