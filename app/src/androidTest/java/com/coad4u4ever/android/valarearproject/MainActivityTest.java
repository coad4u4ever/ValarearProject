package com.coad4u4ever.android.valarearproject;


import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static com.coad4u4ever.android.valarearproject.ViewMatchers.withDrawable;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule
    public final ActivityRule<MainActivity> main = new ActivityRule<>(MainActivity.class);

    @Test
    public void shouldBeAbleToLaunchMainScreen() {
        onView(withId(R.id.main_layout))
                .check(matches(isDisplayed()));
    }

    @Test
    public void shouldHavePlayMusicButton() {
        onView(withId(R.id.img_instant))
                .check(matches(isDisplayed()));
    }

    @Test
    public void instantButtonShouldClickable() {
        onView(withId(R.id.img_instant))
                .check(matches(isClickable()));
    }

    @Test
    public void instantButtonShouldHaveImgPlayWhenAppLunch() {
        onView(withId(R.id.img_instant))
                .check(matches(withDrawable(R.drawable.img_play)));
    }

    @Test
    public void instantButtonShouldChangeDescriptionWhenClick() {
        onView(withId(R.id.img_instant))
                .check(matches(withContentDescription("music is not playing now")));
        onView(withId(R.id.img_instant))
                .perform(click()).check(matches(withContentDescription("music is playing now")));
    }

    @Test
    public void instantButtonShouldChangeFromPlayToPauseImgWhenClick() {
        onView(withId(R.id.img_instant))
                .perform(click()).check(matches(withDrawable(R.drawable.img_pause)));
    }

    @Test
    public void instantButtonShouldChangeFromPauseToPlayImgWhenClick() {
        onView(withId(R.id.img_instant)).perform(click());
        onView(withId(R.id.img_instant))
                .perform(click()).check(matches(withDrawable(R.drawable.img_play)));
    }


}
