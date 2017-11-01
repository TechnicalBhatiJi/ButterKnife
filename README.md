# ButterKnife
ButterKnife Technical Bhati Ji
Simple plug-in for Android Studio/IDEA that allows one-click creation of [Butterknife](https://github.com/JakeWharton/butterknife) view injections.

## How to install

- in Android Studio: go to `Preferences → Plugins → Browse repositories` and search for `ButterKnife Bhati Ji`

_or_

- [download it](http://plugins.jetbrains.com/plugin/7369) and install via `Preferences → Plugins → Install plugin from disk`


## How to use it

 1. Make sure you have latest [Butterknife](https://github.com/JakeWharton/butterknife) lib on your classpath
 2. Right click on usage of desired layout reference (e.g. R.layout.activity_main in your Activity or Fragment), then `Generate` and `Generate ButterKnife Injections`
 3. Pick injections you want, you also have an option to create ViewHolder for adapters.
 4. Click `Confirm` and enjoy injections in your code with no work!


## Contributing

Pull requests are welcomed!

- make sure you stick to [our coding style](/code-formatting-config.xml).
- follow [Getting Started with Plugin Development](http://confluence.jetbrains.com/display/IDEADEV/Getting+Started+with+Plugin+Development)
- make sure you have Java 6 installed if you want to publish it in the plugin repository

## Common issue: The plugin is not working after I updated to new Android Studio
- AS promts you to update plugins after update, you need to update them before using
- Make sure you have Butterknife on your classpath
- Make sure that your cursor is placed on a layout ID in a class having one of these types: Activity, Fragment, custom View or Adapter 

# Blog

 [Visit Blog](https://medium.com/technical-bhait-ji)
 [How does work ButterKnife  viewbinding Tutorial by using Gradle library for Android (Beginner guide)](http://technicalbhatiji.com/butterknife%E2%80%8A-viewbinding-tutorial-by-using-gradle-library/)

## License

```
    Copyright [yyyy] [name of copyright owner]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
    ```