package Seminar_4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Dictionaries {
    public <K, V> Map<V, HashSet<K>> changeKeyValue(Map<K, V> dict){
        Map<V, HashSet<K>> dict2 = new HashMap<V, HashSet<K>>();
        for (Map.Entry<K, V> ent: dict.entrySet()) {
            dict2.compute(ent.getValue(), (v, ks) -> {
                if (ks == null) {
                    ks = new HashSet<>();
                }
                ks.add(ent.getKey());
                return ks;
            });
        }
        return dict2;
    }
}
