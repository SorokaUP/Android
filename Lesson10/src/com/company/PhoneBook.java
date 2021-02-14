package com.company;

import java.util.ArrayList;
import java.util.Objects;

public class PhoneBook {
    private ArrayList items;

    public PhoneBook() {
        this.items = new ArrayList();
    }

    public void add(String lastName, String phone)
    {
        PhoneItem newItem = new PhoneItem(lastName, phone);
        if (!this.items.contains(newItem))
        {
            this.items.add(newItem);
        }
    }

    public ArrayList get(String lastName)
    {
        ArrayList res = new ArrayList();

        for (Object item : this.items)
        {
            if (item instanceof PhoneItem) // Так как тему с <E> не проходили, приходится так извращаться
            {
                PhoneItem pi = (PhoneItem)item;
                if (pi.getLastName() == lastName)
                    res.add(pi.getPhone());
            }
        }

        return res;
    }

    public class PhoneItem
    {
        private String lastName;
        private String phone;

        public PhoneItem(String lastName, String phones) {
            this.lastName = lastName;
            this.phone = phones;
        }

        public String getLastName() {
            return lastName;
        }

        public String getPhone() {
            return phone;
        }

        @Override
        public int hashCode() {
            return Objects.hash(lastName, phone);
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof PhoneItem))
                return false;
            PhoneItem o = (PhoneItem)obj;
            return o.getLastName() == this.getLastName() &&
                    o.getPhone() == this.getPhone();
        }
    }
}
