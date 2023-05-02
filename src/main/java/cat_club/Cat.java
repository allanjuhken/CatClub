package cat;

import catOwner.CatOwner;

public class Cat {
    private long id;
    private String breed;
    private long rating;
    private boolean gender;
    private CatOwner catOwner;

    public Cat(){}

    public Cat(long id, String breed, long rating, boolean gender, CatOwner catOwner) {
        this.id = id;
        this.breed = breed;
        this.rating = rating;
        this.gender = gender;
        this.catOwner = catOwner;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public long getRating() {
        return rating;
    }

    public void setRating(long rating) {
        this.rating = rating;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public CatOwner getCatOwner() {
        return catOwner;
    }

    public void setCatOwner(CatOwner catOwner) {
        this.catOwner = catOwner;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "id=" + id +
                ", breed='" + breed + '\'' +
                ", rating=" + rating +
                ", gender=" + gender +
                ", catOwner=" + catOwner +
                '}';
    }
}
