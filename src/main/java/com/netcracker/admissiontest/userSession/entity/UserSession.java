package com.netcracker.admissiontest.userSession.entity;

import com.netcracker.admissiontest.user.entity.User;

import javax.persistence.*;
import java.util.Date;


//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
@Entity
@Table(name="user_session")
public class UserSession{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="start_date", columnDefinition = "DATETIME")
    @Temporal(TemporalType.DATE)
    private Date start_date;

    @Column(name="end_date", columnDefinition = "DATETIME")
    @Temporal(TemporalType.DATE)
    private Date end_date;

    public UserSession(){

    }

    public UserSession(Date start_date, Date end_date) {
        this.start_date = start_date;
        this.end_date = end_date;
    }



    //@JsonBackReference
    //@JoinColumn(name = "user_id")
    //@JsonManagedReference
    //@JsonIgnoreProperties("user")
    @OneToOne(cascade = CascadeType.ALL)
    private User user;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
