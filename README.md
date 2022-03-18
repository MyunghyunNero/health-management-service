# 토이 프로젝트 : 헬스 관리 서비스 만들기

### 요구사항
 * 헬스 일정 등록하기   (구현)
 * 헬스 일정 조회하기   (구현)
 * 헬스 일정 완료하면 완료 체크 하기   (구현)
 * 헬스 일정 삭제하기 //클릭시 무작동하넹...
 * 헬스 일정 수정하기  (구현)
 
 * 헬스 부위 구분하기 (어꺠,팔,가슴,등,하체)   (구현)   
 
 
 ### 데이터   (구현)
 
  * health    
    * long) number   
    * (string) datetime //날짜   
    * (enum) health location //헬스 부위   
    * (string) exercise //운동 이름   
    * (int) set //세트 횟수  
    * (int) count //세트당 횟수   
  * health location   
    * shoulder   
    * arm   
    * chest   
    * back   
    * lower body   


 ### 기능
  * findAll() // 모든 목록 출력       (구현)
  * save() // 저장                 (구현)
  * findByLocation() // 부위별로 저장 (구현)
  * delete()  //삭제       구현했는데 무작동함 왜이럴까..
  * changeState()   // 완료 변화 (구현)
  * findbyId()       //id를 통해 객체 찾기(구현)
  * update()   //수정          (구현)

 ### 폼
  * addForm // 등록하는 폼       (구현)
  * healths  // 헬스 목록 폼       (구현)
  * location   // 부위 별로 목록 폼  (구현)
  * editForm   // 수정 폼   (구현)



## 삭제 기능, 완료 체크 기능 외의 기능들 


https://user-images.githubusercontent.com/91003734/159004362-d8bae99d-b248-4a40-a599-ce1c402375c6.mp4


    

