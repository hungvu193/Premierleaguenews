# Premierleaguenews
A simple project Android use Retrofit and Material Design

This app use free api from http://www.football-data.org
To protect the API from unnecessary load it is throttled. Non-authenticated clients are allowed for 100 requests per 24 hours,
which is enough to see if it’s worth registering. Registered clients are allowed for 50 requests per minute by default. 
However, only rarely there is need for such high rates, so if one of my guarding-algorithms detects abnormal or foolish requests,
I will first try to contact you via mail to try to find out the reasons for your load. Mostly some sort of caching resolves the issue, 
sometimes I loosen rate limits. However, depending on the load and your response time I may suspend your account and/or ban your IP.
But you can register many api-keys from https://www.football-data.org/client/register.
You can use current api-key that i have created or use you own api key then change it on https://github.com/hungvu193/Premierleaguenews/blob/master/app/src/main/res/values/strings.xml at .
For more infomations about api and lisence please visit this website : https://www.football-data.org/documentation
