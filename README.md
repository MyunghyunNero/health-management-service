# 토이 프로젝트 : 헬스 관리 서비스 만들기


##추가구현

데이터베이스 연결,로그인 기능 연결,검증기능 사용 


### 요구사항

 * 헬스 일정 등록하기   (구현)
 * 헬스 일정 조회하기   (구현)
 * 헬스 일정 완료하면 완료 체크 하기   (구현)
 * 헬스 일정 삭제하기 (구현)
 * 헬스 일정 수정하기  (구현)
 * 헬스 부위 구분하기 (어꺠,팔,가슴,등,하체)   (구현) 
 * 로그인 기능 
 * 헬스 상품 구매 
 * 헬스 상품 취소
 
 
 ### 데이터   (구현)
 * member
    * (long) memberid
    * (health[]) healthdate
    * (order[])  order
 * item
   * (long) itemid 
   * (string) itemname
   * (long)  stockquantity
 * Order
   * (long) orderid
   * (long) memberid
   * 
 * health    
   * (long) number   
   * (string) datetime //날짜   
   * (enum) health location //헬스 부위   
   * (string) exercise //운동 이름   
   * (int) set //세트 횟수  
   * (int) count //세트당 횟수   
   * (string) state // 완료 여부
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
  * delete()  //삭제       (구현)
  * changeState()   // 완료 변화 (구현)
  * findbyId()       //id를 통해 객체 찾기(구현)
  * update()   //수정          (구현)

 ### 폼
  * addForm // 등록하는 폼       (구현)
  * healths  // 헬스 목록 폼       (구현)
  * location   // 부위 별로 목록 폼  (구현)
  * editForm   // 수정 폼   (구현)



## 전부 구현 (예외 처리 등 제외)  -뭔가 어색하고 부족한게 느껴진다.. 



https://user-images.githubusercontent.com/91003734/159005983-5ae236f2-6f37-4d4f-8878-5b77e6aa7544.mp4




    

