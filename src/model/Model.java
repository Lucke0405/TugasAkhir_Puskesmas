package model;

import modelJson.ModelJSON;

import java.util.ArrayList;

public abstract class Model<T> {
    protected ArrayList<T> dataList;
    protected ModelJSON<T> modelJSON;

    public Model(String filePath) {
        dataList = new ArrayList<>();
        modelJSON = new ModelJSON<>(filePath);
        loadData();
    }

    protected abstract void loadData();

    public void commitData() {
        modelJSON.writeToFile(dataList);
    }
}
