package example.com.gpp0102.home.presenter;

import example.com.gpp0102.MainActivity;
import example.com.gpp0102.api.Api;
import example.com.gpp0102.home.model.HomeModel;

public class HomePresenter implements IHomePresenter,HomeModel.Modulecall {
    MainActivity mainActivity;
    private final HomeModel homeModel;


    public HomePresenter(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        homeModel = new HomeModel(this);
    }

    @Override
    public void getPresenterData() {
        homeModel.getModelData(Api.SHOUYE);
    }
    @Override
    public void LoadSuccess(String data) {
        mainActivity.getViewData(data);
    }

    @Override
    public void Failed() {

    }
}
