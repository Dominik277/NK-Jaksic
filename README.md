# NK Jakšić
NK-Jaksic is a small application about my local football team with all infomartion about results, matches, players and league tables. This app is based on modern Android 
application tech-stacks, and MVVM architecture and also this app is made in single activity multiple fragments design pattern.
App is stil in a process of making.

# About
This app is used mainly for displaying content about my local football club, for now it's implemented that when user clicks on some specific item in RecyclerView then app navigates him to the detail fragment where there are displayed all informations about some specific match or detail about new news that are bound to the club. When long clicked on some item in RecylcerView we are navigated to a login fragment where admin logs in and only he can update data in database or delete data in database.We add data in a fragments which we open on a menu item click.This app is still in process of making and long from where I imagine it should be so there will be more features in future.

<p float="left">
  <img src="https://user-images.githubusercontent.com/64093104/110255885-56062f80-7f96-11eb-997d-f0da4ce88d2d.png" width="200" height="400" />
  <img src="https://user-images.githubusercontent.com/64093104/110255630-02471680-7f95-11eb-8184-5e2bb8908d91.png" width="200" height="400"/> 
  <img src="https://user-images.githubusercontent.com/64093104/110255937-94035380-7f96-11eb-8199-6c534be2e53b.png" width="200" height="400"/>
</p>

<p float="left">
    <img src="https://user-images.githubusercontent.com/64093104/110255967-a9787d80-7f96-11eb-91af-8fe280d42ac3.png" width="200" height="400"/>
  <img src="https://user-images.githubusercontent.com/64093104/110256029-ef354600-7f96-11eb-9803-580c572ca528.png" width="200" height="400" />
  <img src="https://user-images.githubusercontent.com/64093104/110256035-fb210800-7f96-11eb-8ee8-209189106545.png" width="200" height="400"/> 
</p>

<p float="left"> 
  <img src="https://user-images.githubusercontent.com/64093104/110256060-1ab83080-7f97-11eb-82c3-a617f7fa2c2b.png" width="200" height="400"/>
  <img src="https://user-images.githubusercontent.com/64093104/110256290-56072f00-7f98-11eb-9aa9-c09e1c120d4b.png" width="200" height="400"/>
</p>

<p float="left">
  <img src="https://user-images.githubusercontent.com/64093104/115158532-e4d69380-a08e-11eb-969c-54aa115e5301.png" width="200" height="400"/>
  <img src="https://user-images.githubusercontent.com/64093104/115158900-d12c2c80-a090-11eb-997a-eed214eadcff.png" width="200" height="400"/>
  <img src="https://user-images.githubusercontent.com/64093104/115159077-aee6de80-a091-11eb-8e1e-abd2584c52e5.png" width="200" height="400"/>
  <img src="https://user-images.githubusercontent.com/64093104/115159407-413bb200-a093-11eb-9c7a-f42a76a9898c.png" width="200" height="400"/>
</p>


# Tech stack & Open-source libraries 🛠
- Minimum SDK Level 26
- [Kotlin](https://kotlinlang.org/) - First class and official programming language for Android development.
- [Coroutines](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/) - For asynchronous and non-blocking programming
- [Flow](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/) - A cold asynchronous data stream that sequentially emits values and completes normally or with an exception.
- [Navigation Component](https://developer.android.com/guide/navigation) -  Android Jetpack's Navigation component helps you implement navigation, from simple button clicks to more complex patterns, such as app bars and the navigation drawer.
- - [Dependency Injection](https://developer.android.com/training/dependency-injection)
    - [Hilt-Dagger](https://dagger.dev/hilt/) - Standard library to incorporate Dagger dependency injection into an Android application.
    - [Hilt-ViewModel](https://developer.android.com/training/dependency-injection/hilt-jetpack) - Dependecy injection for injecting ViewModel.
- [Android Architecture Components](https://developer.android.com/topic/libraries/architecture) - Collection of libraries that help you design robust, testable, and maintainable apps.
    - [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle) - perform actions in response to a change in the lifecycle status of another component, such as activities and fragments.
    - [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - Data objects that notify views when the underlying database changes.
    - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Stores UI-related data that isn't destroyed on UI changes.
    - [ViewBinding](https://developer.android.com/topic/libraries/view-binding) - Generates a binding class for each XML layout file present in that module and allows you to more easily write code that interacts with views.
    - [Android KTX](https://developer.android.com/kotlin/ktx) - provide concise, idiomatic Kotlin to Jetpack and Android platform APIs.
    - [AndroidX](https://developer.android.com/jetpack/androidx) - major improvement to the original Android Support Library, which is no longer maintained.
    - [Room](https://developer.android.com/training/data-storage/room) - SQLite object mapping library.
- Architecture
    - [MVVM Architecture](https://developer.android.com/jetpack/guide?gclid=CjwKCAiAkJKCBhAyEiwAKQBCkrariGLVBTGun7TGT9IMaVf0ojoXdjIc-5tz-jl1L-CM7EsWjQrExRoCHO0QAvD_BwE&gclsrc=aw.ds) (View - DataBinding - ViewModel - Model)
    - Repository pattern

# Arhitecture
The architecture of the application is based, apply and strictly complies with each of the following 5 points:
- A single-activity architecture
- Android architecture components, part of Android Jetpack for give to project a robust design, testable and maintainable.
- Pattern Model-View-ViewModel (MVVM) facilitating a separation of development of the graphical user interface.
- S.O.L.I.D design principles intended to make software designs more understandable, flexible and maintainable.
- Modular app architecture allows to be developed features in isolation, independently from other features.

![mvvm-architecture-app-in-android](https://user-images.githubusercontent.com/64093104/110252926-07519900-7f88-11eb-9736-055484d79338.png)

