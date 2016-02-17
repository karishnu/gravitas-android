package maps.gaurav.com.gravitas.classes;

import com.orm.SugarRecord;

/**
 * Created by striker on 2/17/16.
 */
public class Participantdb extends SugarRecord {
    private String _id;
    private Participant[] participants;

    public Participantdb(String id, Participant[] participants) {
        _id = id;
        this.participants = participants;
    }
}

class Participant extends SugarRecord {

    private String name;
    private String phone;
    private String room;
    private String regno;
    private String email;
    private String time;
    private String type;
    private String university;
    private String combo;

    Participant(String name, String phone, String room, String regno, String email, String time, String type, String university, String combo) {
        this.name = name;
        this.phone = phone;
        this.room = room;
        this.regno = regno;
        this.email = email;
        this.time = time;
        this.type = type;
        this.university = university;
        this.combo = combo;
    }
}