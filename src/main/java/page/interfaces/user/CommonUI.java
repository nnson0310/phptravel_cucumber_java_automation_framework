package page.interfaces.user;

public interface CommonUI {
    //Uncomment below lines if you prefer not using normalize-space of xpath
    //normalize space will remove all leading, trailing, sequence of white spaces
//    String MY_PROFILE_SIDEBAR_LINK = "xpath=//div[@class='sidebar-menu-wrap']//a[contains(., 'My Profile')]";
    String MY_PROFILE_SIDEBAR_LINK = "xpath=//div[@class='sidebar-menu-wrap']//a[normalize-space(text())='My Profile']";
    String DYNAMIC_TEXTBOX_BY_NAME_ATTRIBUTE = "xpath=//input[@name='%s']";
    String ADD_FUNDS_SIDEBAR_LINK = "xpath=//div[@class='sidebar-menu-wrap']//a[normalize-space(text())='Add Funds']";
}
