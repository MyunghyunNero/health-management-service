package health.health.management.domain;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class healthRepository {

    private static final Map<Long,health> store = new HashMap<>();
    private static Long sequence=0L;

    public health save(health h){
        h.setNum(++sequence);
        store.put(h.getNum(),h);
        return h;
    }
    public List<health> findAll(){
        return new ArrayList<>(store.values());
    }

}
