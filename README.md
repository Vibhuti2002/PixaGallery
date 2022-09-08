# **PixaGallery** 

### **PixaGallery** is a simple gallery app which fetches images from Pixaby API!

## App Features

- **Images Based On Color** - Fetches image with selected color tag.
- **Images Based On Category** - Fetches image with selected category tag.
- **Images loaded in list** - All images are loaded in grid list.
- **Full screen Image** - Full screen image can be seen in both potrit and landscape mode. 

## 📸 Screenshots 

|   |   |   |
|---|---|---|
|![pixa1](https://user-images.githubusercontent.com/69722542/189096693-e4a85334-035b-4d68-adc5-af17b4385d37.jpeg)| ![pixa2](https://user-images.githubusercontent.com/69722542/189096764-4f5f4858-7065-4dfe-bcab-9d647cfa5691.jpeg) | ![pixa3](https://user-images.githubusercontent.com/69722542/189096792-6bf6841a-5660-43c8-92de-cb2bfff2f2ea.jpeg)
|![pixa4](https://user-images.githubusercontent.com/69722542/189096871-99a840ab-12cf-4339-a136-2b924041e071.jpeg) | ![pixa5](https://user-images.githubusercontent.com/69722542/189096898-f657278e-0c28-4273-83ad-8d497dc245f3.jpeg) |![pixa6](https://user-images.githubusercontent.com/69722542/189096932-20527f08-85dd-420e-ae1d-39b4d81bbcc2.jpeg) 
|![pixa7](https://user-images.githubusercontent.com/69722542/189096981-46693f10-7f63-4dfe-8dc2-442b7a10b70f.jpeg)|![pixa8](https://user-images.githubusercontent.com/69722542/189097028-a3e17a9f-8b42-4b0d-9c61-3323cf5c510e.jpeg) | 


### Technical details 

- PixaGallery uses Retrofit to make all REST API calls.
- PixaGallery is made using Kotlin and following Modern Android Development practices.
- PixaGallery uses Kotlin Coroutines and LiveData to handle all asynchronous tasks.
- PixaGallery uses all Jetpack libraries and follows MVVM architecture.



## Built With 🛠
- [Pixabay API](https://pixabay.com/api/docs/) - RESTful interface for searching and retrieving free images and videos 
- [Kotlin](https://kotlinlang.org/) - First class and official programming language for Android development.
- [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) - For asynchronous and more..
- [Android Architecture Components](https://developer.android.com/topic/libraries/architecture) - Collection of libraries that help you design robust, testable, and maintainable apps.
  - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Stores UI-related data that isn't destroyed on UI changes. 
  - [ViewBinding](https://developer.android.com/topic/libraries/view-binding) - Generates a binding class for each XML layout file present in that module and allows you to more easily write code that interacts with views.
- [GSON](https://github.com/google/gson) - A modern JSON library for Kotlin and
- [Retrofit](https://square.github.io/retrofit/) - A type-safe HTTP client for Android and Java.
- [GSON Converter](https://github.com/square/retrofit/tree/master/retrofit-converters/gson) - A Converter which uses Moshi for serialization to and from JSON.
- [Material Components for Android](https://github.com/material-components/material-components-android) - Modular and customizable Material Design UI components for Android.

## Architecture
This app uses [***MVVM (Model View View-Model)***](https://developer.android.com/jetpack/docs/guide#recommended-app-arch) architecture.
