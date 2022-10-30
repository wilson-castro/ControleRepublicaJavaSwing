package src.services;

import com.google.gson.Gson;
public class Modal {
    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(Modal.this);
    }
}
