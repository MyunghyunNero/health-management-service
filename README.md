# 토이 프로젝트 : 헬스 관리 서비스 만들기

### 요구사항
 * 헬스 일정 등록하기   (구현)
 * 헬스 일정 조회하기   (구현)
 * 헬스 일정 완료하면 완료 체크 하기   
 * 헬스 일정 삭제하기   
 
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
  * delete()  //삭제                   

 ### 폼
  * addForm // 등록하는 폼       (구현)
  * healths  // 헬스 목록 폼       (구현)
  * location   // 부위 별로 목록 폼  (구현



## 삭제 기능, 완료 체크 기능 외의 기능들 


https://user-images.githubusercontent.com/91003734/158183145-f0fb6433-1354-418a-a8d5-37ad2637d470.mp4
    

