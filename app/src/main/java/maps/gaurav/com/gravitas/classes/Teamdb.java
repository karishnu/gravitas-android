package maps.gaurav.com.gravitas.classes;

import com.orm.SugarRecord;

/**
 * Created by striker on 2/17/16.
 */
public class Teamdb extends SugarRecord {
    private String _id;
    private String name;
    private String phone;
    private String email;
    private String type;
    private String room;
    private String team;

    public Teamdb(String id, String name, String phone, String email, String type, String room, String team) {
        _id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.type = type;
        this.room = room;
        this.team = team;
    }
}