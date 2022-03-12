package health.health.management.domain;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.*;

@Repository
public class healthRepository {

    private static final Map<Long,Health> store = new HashMap<>();
    private static Long sequence=0L;
    public Health save(Health health){
        health.setNum(++sequence);
        store.put(health.getNum(),health);
        return health;
    }
    public List<Health> findAll(){
        return new ArrayList<>(store.values());
    }

}
