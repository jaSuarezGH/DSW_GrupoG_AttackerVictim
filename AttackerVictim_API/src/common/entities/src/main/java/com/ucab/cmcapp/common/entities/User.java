package com.ucab.cmcapp.common.entities;


import javax.persistence.*;


@Entity
@Table(name = "user")
public class User {

    public User() {
    }

    public User(User user) {
        _firstname = user._firstname;
        _lastname = user._lastname;
        _username = user._username;
        _personal_id = user._personal_id;
        _email = user._email;
        _mac_address = user._mac_address;
        _userType = user._userType;
    }

    public User(long id) {
        _id = id;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long _id;

    @Column(name = "firstname", nullable = false)
    private String _firstname;

    @Column(name = "lastname", nullable = false)
    private String _lastname;

    @Column(name = "username", nullable = false, unique = true)
    private String _username;

    @Column(name = "personal_id", nullable = false, unique = true)
    private String _personal_id;

    @Column(name = "email", nullable = false, unique = true)
    private String _email;

    @Column(name = "mac_address", nullable = false, unique = true)
    private String _mac_address;

    @Transient
    private String _password;

    @Basic(optional = false)
    @Column(name = "active", insertable = false, updatable = false, columnDefinition = "BOOLEAN DEFAULT TRUE")
    private Boolean _active;

    /*@Basic(optional = false)
    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",
            insertable = false, updatable = false, nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date _createAt;*/

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_type_id", nullable = false)
    private UserType _userType;

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String get_firstname() {
        return _firstname;
    }

    public void set_firstname(String _firstname) {
        this._firstname = _firstname;
    }

    public String get_lastname() {
        return _lastname;
    }

    public void set_lastname(String _lastname) {
        this._lastname = _lastname;
    }

    public String get_username() {
        return _username;
    }

    public void set_username(String _username) {
        this._username = _username;
    }

    public String get_personal_id() {
        return _personal_id;
    }

    public void set_personal_id(String _license) {
        this._personal_id = _license;
    }

    public String get_email() {
        return _email;
    }

    public void set_email(String _email) {
        this._email = _email;
    }

    public String get_mac_address() {
        return _mac_address;
    }

    public void set_mac_address(String _mac_address) {
        this._mac_address = _mac_address;
    }

    public String get_password() {
        return _password;
    }

    public void set_password(String _password) {
        this._password = _password;
    }

    public UserType get_userType() {
        return _userType;
    }

    public void set_userType(UserType _userType) {
        this._userType = _userType;
    }

    public Boolean get_active() {
        return _active;
    }

    public void set_active(Boolean _active) {
        this._active = _active;
    }
}
