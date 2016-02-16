package com.softdesign.school.data.storage.models;

import android.graphics.drawable.Drawable;

/** Модель пользователя
    mId - id
    mFirstName - имя
    mLastName - фамилия
    mEmail - мыло
    mPhone - телефонный номер
    mImage - аватар
    mVk - сслыка vk
    mGit - ссылка на Git
    mRate - рейтинг
    mHomeTask - текущее домашнее задание
 */

public class User {
    private int mId;
    private String mFirstName;
    private String mLastName;
    private String mEmail;
    private String mPhone;
    private Drawable mImage;
    private String mVk;
    private String mGit;
    private int mRate;
    private int mHometask;

    public User(Drawable image, String firstName, String lastName) {
        this.mFirstName = firstName;
        this.mLastName = lastName;
        this.mImage = image;
    }

    public int getmHometask() {
        return mHometask;
    }

    public String getmPhone() {
        return mPhone;
    }

    public Drawable getmImage() {
        return mImage;
    }

    public String getmVk() {
        return mVk;
    }

    public String getmGit() {
        return mGit;
    }

    public int getmRate() {
        return mRate;
    }

    public String getmEmail() {
        return mEmail;
    }

    public String getmLastName() {
        return mLastName;
    }

    public String getmFirstName() {
        return mFirstName;
    }

    public int getmId() {
        return mId;
    }

    public void setmHometask(int mHometask) {
        this.mHometask = mHometask;
    }

    public void setmRate(int mRate) {
        this.mRate = mRate;
    }

    public void setmGit(String mGit) {
        this.mGit = mGit;
    }

    public void setmVk(String mVk) {
        this.mVk = mVk;
    }

    public void setmPhone(String mPhone) {
        this.mPhone = mPhone;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }
}
