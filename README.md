# reactionGame

| column name | type        | ex            |
|-------------|-------------|---------------|
| idx         | int         | PK,AI         |
| date        | datetime    | java NOW()    |
| name        | varchar(20) | no duplicates |
| ratetime    | int         | game result   |


### Users
|  url         | method | desc                         |
|--------------|--------|------------------------------|
| members      |        |                              |
| /memberes    | get    |모든 유저 정보를 가져온다      |
| /members/{idx}| get   |idx를 가진 유저 정보를 가져온다|
| /members     | post   |유저정보 입력을요청한다        |
| /members/{idx}  patch  |idx를 가진 유저 정보를 수정한다|
| /members/{idx} | delete |idx를 가진 유저 정보를 삭제한다|

### Ranking
|url                | method | desc   |
|-------------------|--------|--------|
| members           |        |        |
| /members/rank     | get    |주간 랭킹|
| /members/{idx}/percent | get    |idx 해당 유저 상위 |
^
