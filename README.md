
<img src="graphics/head.png" height="154" align="center">

**IconBadge** is a simple library that facilitates the use of **badges** in your **icons**. You have a lot of options to customize the badges, start using it! It's **easy** and **intuitive**

-----

## Install
Add this dependency to your app build.gradle file:
```gradle
dependencies {
    compile 'com.frandioniz.iconbadge:iconbadge:1.0'
}
```

## Use of IconBadge
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

This library use the [JoanZapata/android-iconify](https://github.com/JoanZapata/android-iconify) library for icons. You can use any icon in this library, setting the value in xml or java code.


```xml
<!-- xml -->
app:iconsrc="{fa-android}"
```

```java
// java
iconBadge.setIcon("{fa-android}");
```

You can also use drawables, setting the drawable resource id in the functions:


```xml
<!-- xml -->
app:iconsrcDrawable="@drawable/ic_android"
```

```java
// java
iconBadge.setIcon(R.drawable.ic_launcher_background);
```

You can customize your badge with multiple options!

<img src="graphics/icons.png" height="512" align="center">


## License
Copyright 2017 Fran Dioniz

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.