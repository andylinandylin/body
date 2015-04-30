package com.android.floatbutton;

//==================================
//                 Location information
//==================================

public class Contact {

    // private variables
    public int _id;
    public String _name;
    public String _latitude;
    public String _longitude;
    public String _note;

    public Contact() {
    }

    // constructor
    public Contact(int id, String name, String _latitude, String _longitude, String _note) {
	this._id = id;
	this._name = name;
	this._latitude = _latitude;
	this._longitude = _longitude;
    this._note = _note;
    }

    // constructor
    public Contact(String name, String _latitude, String _longitude, String _note) {
	this._name = name;
	this._latitude = _latitude;
	this._longitude = _longitude;
    this._note = _note;
    }

    public int getID() {
	return this._id;
    }

    public void setID(int id) {
	this._id = id;
    }

    public String getName() {
	return this._name;
    }

    public void setName(String name) {
	this._name = name;
    }

    public String getLatitude() {
	return this._latitude;
    }

    public void setLatitude(String latitude) {
	this._latitude = latitude;
    }

    public String getLongitude() {
	return this._longitude;
    }

    public void setLongitude(String longitude) {
	this._longitude = longitude;
    }

    public String getNote() {
        return this._note;
    }

    public void setNote(String note) {
        this._note = note;
    }
}