package maps.gaurav.com.gravitas.classes;

import com.orm.SugarRecord;

/**
 * Created by striker on 2/17/16.
 */
public class EventDb extends SugarRecord {

    private String _id;
    private String status;
    private Coordinators[] coordinators;
    private Faculty faculty;
    private Event event;
    private Finance finance;
    private Guest[] guest;
    private int team;
    private String miscellaneous;
    private String remarks;

    public EventDb(String id, String status, Coordinators[] coordinators, Faculty faculty, Event event, Finance finance, Guest[] guest, int team, String miscellaneous, String remarks) {
        _id = id;
        this.status = status;
        this.coordinators = coordinators;
        this.faculty = faculty;
        this.event = event;
        this.finance = finance;
        this.guest = guest;
        this.team = team;
        this.miscellaneous = miscellaneous;
        this.remarks = remarks;
    }
}

class Coordinators extends SugarRecord {

    private String reg_no;
    private String phone_no;
    private String name;
    private String email;
    private String room;

    Coordinators(String reg_no, String phone_no, String name, String email, String room) {
        this.reg_no = reg_no;
        this.phone_no = phone_no;
        this.name = name;
        this.email = email;
        this.room = room;
    }
}

class Faculty extends SugarRecord {


    private String faculty_id;
    private String phone_no;
    private String name;
    private String email;
    private String room;

    Faculty(String faculty_id, String phone_no, String name, String email, String room) {
        this.faculty_id = faculty_id;
        this.phone_no = phone_no;
        this.name = name;
        this.email = email;
        this.room = room;
    }
}

class Event extends SugarRecord {

    private String name;
    private String type;
    private String org;
    private Schedule schedule;
    private String summary;
    private String page;
    private String description;

    Event(String name, String type, String org, Schedule schedule, String summary, String page, String description) {
        this.name = name;
        this.type = type;
        this.org = org;
        this.schedule = schedule;
        this.summary = summary;
        this.page = page;
        this.description = description;
    }
}

class Finance extends SugarRecord {

    private int fees;
    private Prize prize;
    private Sponsorship sponsorship;
    private Registrations registrations;
    private int income;
    private Budget budget;
    private int expenditure;
    private int profit;

    Finance(int fees, Prize prize, Sponsorship sponsorship, Registrations registrations, int income, Budget budget, int expenditure, int profit) {
        this.fees = fees;
        this.prize = prize;
        this.sponsorship = sponsorship;
        this.registrations = registrations;
        this.income = income;
        this.budget = budget;
        this.expenditure = expenditure;
        this.profit = profit;
    }
}

class Guest extends SugarRecord {

    private String name;
    private Travel travel;
    private Stay stay;
    private Food food;

    Guest(String name, Travel travel, Stay stay, Food food) {
        this.name = name;
        this.travel = travel;
        this.stay = stay;
        this.food = food;
    }
}

class Schedule extends SugarRecord {

    private String venue;
    private String date;
    private String time;

    Schedule(String venue, String date, String time) {
        this.venue = venue;
        this.date = date;
        this.time = time;
    }
}

class Prize extends SugarRecord {

    private int total;
    private int[] breakdown;

    Prize(int total, int[] breakdown) {
        this.total = total;
        this.breakdown = breakdown;
    }
}

class Sponsorship extends SugarRecord {

    private int total;
    private Breakdown[] breakdown;

    Sponsorship(int total, Breakdown[] breakdown) {
        this.total = total;
        this.breakdown = breakdown;
    }
}

class Registrations extends SugarRecord {

    private int total;
    private String current;
    private String individual;
    private Combos combos;

    Registrations(int total, String current, String individual, Combos combos) {
        this.total = total;
        this.current = current;
        this.individual = individual;
        this.combos = combos;
    }
}

class Budget extends SugarRecord {

    private Mementos mementos;
    private Purchase[] purchase;
    private Tags tags;
    private Certificates certificates;
    private int travel;
    private int food;
    private int stay;

    Budget(Mementos mementos, Purchase[] purchase, Tags tags, Certificates certificates, int travel, int food, int stay) {
        this.mementos = mementos;
        this.purchase = purchase;
        this.tags = tags;
        this.certificates = certificates;
        this.travel = travel;
        this.food = food;
        this.stay = stay;
    }
}

class Travel extends SugarRecord {

    private int amount;
    private String from;

    Travel(int amount, String from) {
        this.amount = amount;
        this.from = from;
    }
}

class Stay extends SugarRecord {

    private int duration;

    Stay(int duration) {
        this.duration = duration;
    }
}

class Food extends SugarRecord {

    private int units;

    Food(int units) {
        this.units = units;
    }
}

class Breakdown extends SugarRecord {

    private String source;
    private String type;
    private int amount;

    Breakdown(String source, String type, int amount) {
        this.source = source;
        this.type = type;
        this.amount = amount;
    }
}

class Combos extends SugarRecord {

    private int overall;
    private int[] breakdown;

    Combos(int overall, int[] breakdown) {
        this.overall = overall;
        this.breakdown = breakdown;
    }
}

class Mementos extends SugarRecord {

    private int units;
    private int costs;

    Mementos(int units, int costs) {
        this.units = units;
        this.costs = costs;
    }
}

class Purchase extends SugarRecord {

    private String id;
    private String quantity;
    private int cost;

    Purchase(String id, String quantity, int cost) {
        this.id = id;
        this.quantity = quantity;
        this.cost = cost;
    }
}

class Tags extends SugarRecord {

    private int units;
    private int cost;

    Tags(int units, int cost) {
        this.units = units;
        this.cost = cost;
    }
}

class Certificates extends SugarRecord {

    private int coordinator;
    private int participant;
    private int cost;
    private int winner;
    private int total;

    Certificates(int coordinator, int participant, int cost, int winner, int total) {
        this.coordinator = coordinator;
        this.participant = participant;
        this.cost = cost;
        this.winner = winner;
        this.total = total;
    }
}