package maps.gaurav.com.gravitas.classes;

import com.orm.SugarRecord;

/**
 * Created by striker on 2/17/16.
 */
public class Orgdb extends SugarRecord {
    private String _id;
    private String name;
    private String type;

    public Orgdb(String id, String name, String type) {
        _id = id;
        this.name = name;
        this.type = type;
    }
}