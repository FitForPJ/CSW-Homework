package com.thanar.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jioke on 9/10/17.
 */

public class People implements Parcelable {
  // book basics
  private String name;
  private String surname;
  private int resId;

  // main constructor
  public People(String name, String surname ,int resId) {
    this.name = name;
    this.surname = surname;
    this.resId = resId;
  }

  // getters
  public String getName() { return name; }
  public String getSurname() { return surname; }
  public int getResId() {return resId;}

  // write object values to parcel for storage
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(name);
    dest.writeString(surname);
    dest.writeInt(resId);
  }

  public People(Parcel parcel) {
    name = parcel.readString();
    surname = parcel.readString();
    resId = parcel.readInt();

  }

  public static final Creator<People> CREATOR = new Creator<People>() {

    @Override
    public People createFromParcel(Parcel parcel) {
      return new People(parcel);
    }

    @Override
    public People[] newArray(int size) {
      return new People[size];
    }
  };

  public int describeContents() {
    return hashCode();
  }
}
