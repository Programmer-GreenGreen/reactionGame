# reactionGame

| column name | type        | ex            |
|-------------|-------------|---------------|
| idx         | int         | PK,AI         |
| date        | datetime    | java NOW()    |
| name        | varchar(20) | no duplicates |
| ratetime    | int         | game result   |


### Users
|  url         | method | desc                        |
|--------------|--------|-----------------------------|
| users        |        |                             |
| /users       | get    |모든 유저 정보를 가져온다      |
| /users/{idx} | get    |idx를 가진 유저 정보를 가져온다|
| /users       | post   |유저정보 입력을요청한다        |
| /users/{idx} | patch  |idx를 가진 유저 정보를 수정한다|
| /users/{idx} | delete |idx를 가진 유저 정보를 삭제한다|

### Ranking
|url                | method | desc   |
|-------------------|--------|--------|
| users             |        |        |
| /users/rank       | get    |하루 랭킹|
| /users/total-rank | get    |모든 랭킹|
^.^
