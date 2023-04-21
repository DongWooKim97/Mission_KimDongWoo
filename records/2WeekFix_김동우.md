# 2WeekFix_김동우.md

## Title: [2WeekFix] 김동우

### 미션 요구사항 분석 & 체크리스트

---

### N주차 미션 요약

1. 한명의 인스타회원이 다른 인스타회원에게 중복으로 호감표시를 할 수 없습니다.
2. 한명의 인스타회원이 11명 이상의 호감상대를 등록 할 수 없습니다.
3. 중복으로 호감표시하는 상황이 발생했을 때 기존의 사유와 다른 사유로 호감을 표시하는 경우에는 성공으로 처리한다.

- [x] 1번 케이스
    - [x] 먼저 입력한 인스타유저가 호감표시가 되어있는지 확인
    - [x] 확인 후, 등록여부에 따라
        - [x] 등록 O -> 처리하면 안됨 (rq.historyBack)
        - [x] 등록 X -> 새로운 등록
    - [x] 등록여부 확인 -> checkDuplicateAttractiveTypeCode()메서드 활용
        - [x] 로그인한 유저의 인스타아이디를 이용해 리스트를 뽑아내고, 이 리스트에서 addForm에서 입력받은 username과 attractiveTypeCode와 일치한 경우를 찾음.


- [x] 2번 케이스
    - [x] 10명까지 호감상대 등록이 가능하고, 11명부터는 호감표시 불가.
        - [x] NotProd를 통해 임시방편 데이터를 생성하고, user12가 user1~10을 호감했지만 user11은 호감표시 못하는 상황 연출
    - [x] 11명 이상부터 등록할 때 rq.historyBack으로 처리

- [ ] 3번 케이스
    - [x] ex) 기존이 호감 : `외모`, 새로운 호감 `성격` 일 경우 새로운 호감등록이 아닌 사유만 수정되는 형식
        - [x] 로그인한 유저의 인스타 정보의 아이디와 로그인한 사람이 입력한 사람의 인스타 정보 아이디를 이용하여 엔티티객체를 받아옴
            - [x] `LikeablePersonRepostiory`
              의 `LikeablePerson findByFromInstaMemberIdAndToInstaMemberId(Long fromInstaMemberId, Long toInstaMemberId);`
        - [x] 이러한 엔티티객체의 id값을 추출하여 새롭게 save하는 작업을 진행
            - [x] `LikeablePersonService`의 `update` 메서드
            - [x] `LikeablePersonService`의 `like` 메서드 처럼 Transactional 어노테이션 추가 및 수정을 위한 Modifying 추가
        - [x] 새로운 엔티티를 작성해서 위로 덮어버리는 작업을 채택. 그렇게 하기 위해 기존의 `like`와 다르게 `.id(updatePersonId)` 를 추가하여 해당 칼럼을 직접 지정 후 저장.
    - [ ] 호감표시 변경 시 resultCode=S-2, msg=`who`에 대한 호감사유를 외모에서 성격으로 변경합니다.
        - [ ] 구현 실패..! 리팩토링때 진행 요망

**[리팩토링]**

