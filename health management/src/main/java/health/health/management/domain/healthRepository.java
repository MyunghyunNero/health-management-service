package health.health.management.domain;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class healthRepository {

    private static final Map<Long,Health> store = new HashMap<>();
    private static Long sequence=0L;
    // 저장
    public Health save(Health health){
        health.setNum(++sequence);
        store.put(health.getNum(),health);
        return health;
    }
    //모든 값 불러오기
    public List<Health> findAll(){
        return new ArrayList<>(store.values());
    }

    // location값으로 일정 찾기
    public List<Health> findByLocation(String location){
        return store.values().stream()
                .filter(health -> health.getLocation().name().equals(location))
                .collect(Collectors.toList());
    }
    // num값으로 일정 찾기
    public Health findById(Long num){
        return store.get(num);
    }
    public void update(Long num,Health updateparam){
        Health findhealth = findById(num);
        findhealth.setDatetime(updateparam.getDatetime());
        findhealth.setSet(updateparam.getSet());
        findhealth.setCount(updateparam.getCount());
    }
    // 일정 삭제하기
    public void delete(Long num){
        store.remove(num);
    }

}
