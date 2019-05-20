package com.example.dzienniktreningowy;

class PartiaMiesni {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String nazwa;

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @Override
    public String toString() {
        return "PartiaMiesni{" +
                "id=" + id +
                ", nazwa='" + nazwa + '\'' +
                '}';
    }
}
