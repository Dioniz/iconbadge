**IconBadge** is a simple library that facilitates the use of **badges** in your **icons**. You have a lot of options to customize the badges, start using it! It's **easy** and **intuitive**

## Install
Add this dependency to your app build.gradle file:
```java
dependencies {
    compile 'com.frandioniz.iconbadge:iconbadge:1.0'
}
```

## Use of IconBadge
This library use the [JoanZapata/android-iconify](https://github.com/JoanZapata/android-iconify) library for icons. You can use any icon in this library, setting the value in ```app:iconsrc``` or ```iconBadge.setIcon()```  property

Insert the **IconBadge** layout to your xml file:
```xml
<com.frandioniz.iconbadge.IconBadge
	android:id="@+id/iconbadge"
	android:layout_width="wrap_content"
	android:layout_height="wrap_content"
	android:layout_gravity="center"
	android:layout_margin="16dp"
	app:iconsrc="{fa-android}"
	app:iconColor="@android:color/holo_green_dark"
	app:iconDimen="20dp"
	app:badgeNumber="6"
	app:badgeDimen="regular"
	app:badgeTextColor="@android:color/white"
	app:badgeBorderWidth="0.9dp"
	app:badgeCornersRadiusBottomRight="12dp"
	app:badgeBorderColor="@android:color/white"
	app:badgeBackgroundColor="@android:color/holo_blue_light"
	app:badgePosition="bottomRight"/>
```

And you can change the properties from Java code:
```java
IconBadge iconBadge = findViewById(R.id.iconbadge);
iconBadge.setIcon("{fa-heart}");
iconBadge.setIconColor(R.color.colorBlue);
iconBadge.setBadgePosition(IconBadge.POS_TOP_LEFT);
iconBadge.setBadgeNumber(1);
iconBadge.setDimens(30, IconBadge.DIM_BIG);
iconBadge.setBadgeTextColor(android.R.color.white);
iconBadge.setBadgeBorderColor(android.R.color.white);
iconBadge.setBadgeBorderWidth(2);
iconBadge.setBadgeBackgroundColor(R.color.colorOrange);
iconBadge.setBadgeCornersRadius(200);
```