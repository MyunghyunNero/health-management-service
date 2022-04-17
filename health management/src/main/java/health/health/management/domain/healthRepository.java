package health.health.management.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.w3c.dom.Entity;

import javax.persistence.EntityManager;
import java.util.*;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class healthRepository {

    private final EntityManager entityManager;
    // 저장
    public Health save(Health health){
        entityManager.persist(health);
        return health;
    }
    //모든 값 불러오기
    public List<Health> findAll(){
        return entityManager.createQuery("select h from Health h",Health.class)
                .getResultList();}

    // location값으로 일정 찾기
    public List<Health> findByLocation(String location){
        return entityManager.createQuery("select h from Health h where h.location= :location",Health.class)
                .setParameter("location",location)
                .getResultList();
    }
    // num값으로 일정 찾기
    public Health findById(Long num){
        return entityManager.find(Health.class,num);
    }
    public void update(Long num,Health updateparam){
        Health findhealth = findById(num);
        findhealth.setDatetime(updateparam.getDatetime());
        findhealth.setSet(updateparam.getSet());
        findhealth.setCount(updateparam.getCount());
    }
    // 일정 삭제하기
    public void delete(Long num){
        Health health =entityManager.find(Health.class,num);
        entityManager.remove(health);
    }


}
