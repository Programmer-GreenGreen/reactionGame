# reactionGame

## site 주소 https://reacting-game.kumas.dev/

DB정보

| column name | type        | ex            |
|-------------|-------------|---------------|
| idx         | int         | PK,AI         |
| date        | datetime    | java NOW()    |
| name        | varchar(20) | no duplicates |
| ratetime    | int         | game result   |

## Dependency  구조
![reactionGame](https://user-images.githubusercontent.com/76862421/148632129-c7d4fe7e-b113-452c-8c38-6c8391c968ed.png)

## API 명세서
### Members
| Method | url            | Parameters            | Request body                                                                   | Responses body                                                                                                          | status : Success                       | status : Fail                                                                                                                                                    |
|--------|----------------|-----------------------|--------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------|----------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Get    | /members       | X                     | X                                                                              | [ { "idx": 64, "date": "2021-12-05T05:36:48.000+00:00", "memberName": "김군", "rateTime": 431, "percent": null }, ... ] | { status : 200 message : “조회 성공” } | { "message": "Server Error", "status": 500, "errors": [], "code": "C004" }                                                                                       |
| Get    | /members{idx}  | idx (Integer) ex : 67 | X                                                                              | { "idx": 67, "date": "2021-12-13T02:33:57.000+00:00", "memberName": "김군", "rateTime": 420, "percent": null }          | { status : 200 message : “조회 성공” } | { "message": "Invalid Input Value", "status": 400, "errors": [], "code": "C001" } { "message": "Entity Not Found", "status": 404, "errors": [], "code": "C003" } |
| Post   | /members       | X                     | { "date": "2021-12-23T07:39:27.273Z", "memberName": "Green", "rateTime": 633 } | X                                                                                                                       | { status: 201 message : “입력 성공” }  | { "message": "Server Error", "status": 500, "errors": [], "code": "C004" } { "message": " Invalid Type Value", "status": 400, "errors": [], "code": "C005" }     |
| Delete | /members/{idx} | idx (Integer)         | X                                                                              | 삭제되었습니다                                                                                                          | { status : 200 message : “삭제 성공” } | { "message": "Invalid Input Value", "status": 400, "errors": [], "code": "C001" } { "message": "Entity Not Found", "status": 404, "errors": [], "code": "C003" } |
| Patch  | /members/{idx} | X                     | { "date": "2021-12-23T12:12:03.024Z", "rateTime": 550 }                        | { "idx": 70, "date": "2021-12-23T12:12:03.033Z", "memberName": "음", "rateTime": 550, "percent": null }                 | { status : 200 message : “수정 성공” } | { "message": "Invalid Input Value", "status": 400, "errors": [], "code": "C001" } { "message": "Entity Not Found", "status": 404, "errors": [], "code": "C003" } |

### Ranking
| Method | url                    | Parameters            | Request body | Responses body                                                                                                                                                                                                                                    | status : Success                       | status : Fail                                                                                                                                                    |
|--------|------------------------|-----------------------|--------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|----------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Get    | /members/{idx}/percent | idx (integer) ex : 92 | X            | { "idx": 92, "date": "2021-12-13T03:36:34.000+00:00", "memberName": "ㅍㅡㄹㅗ틴", "rateTime": 283, "percent": 20 }                                                                                                                                | { status : 200 message : “조회 성공” } | { "message": "Invalid Input Value", "status": 400, "errors": [], "code": "C001" } { "message": "Entity Not Found", "status": 404, "errors": [], "code": "C003" } |
| Get    | /members/rank          | X                     | X            | [ { "idx": 122, "date": "2021-12-20T20:46:54.000+00:00", "memberName": "안녕하세요 공주님", "rateTime": 0, "percent": null }, { "idx": 129, "date": "2021-12-22T22:45:54.000+00:00", "memberName": "핫산", "rateTime": 152, "percent": null },... | { status : 200 message : “조회 성공” } | { "message": "Invalid Input Value", "status": 400, "errors": [], "code": "C001" } { "message": "Entity Not Found", "status": 404, "errors": [], "code": "C003" } |

