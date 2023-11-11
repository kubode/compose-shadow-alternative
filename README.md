![title](./docs/images/title.png)

![Maven Central](https://img.shields.io/maven-central/v/io.github.kubode.compose.shadow/compose-boxshadow)
https://img.shields.io/github/license/kubode/compose-shadow-alternative

Compose has few ways to add shadows.
This library provides box shadows and drop shadows to enrich shadow expression of Compose.

# Install

```kotlin
repositories {
    google()
    mavenCentral()
    // If you want to use the latest snapshot version.
    maven {
        url = uri("https://s01.oss.sonatype.org/content/repositories/snapshots")
        mavenContent {
            snapshotsOnly()
            includeGroup("io.github.kubode.compose.shadow")
        }
    }
}

dependencies {
    implementation("io.github.kubode.compose.shadow:compose-boxshadow:$latestVersion")
    implementation("io.github.kubode.compose.shadow:compose-dropshadow:$latestVersion")
}
```

# Usage

Samples are available in [androidApp](./androidApp).

## DropShadow

Simple usage:
```kotlin
DropShadow(
    color = Color.Black.copy(alpha = 0.5f),
    offset = DpOffset(4.dp, 4.dp),
    radius = 8.dp,
) {
    Image(
        painter = painterResource(id = R.drawable.ic_android_black_24dp),
        contentDescription = null,
        modifier = Modifier.size(48.dp),
        colorFilter = ColorFilter.tint(Color(0xFF3DDC84)),
    )
}
```

With animation:
```kotlin
val infiniteTransition = rememberInfiniteTransition(label = "infinite")
val degrees by infiniteTransition.animateFloat(
    initialValue = 0f,
    targetValue = 360f,
    animationSpec = infiniteRepeatable(
        animation = tween(durationMillis = 1000, easing = LinearEasing)
    ),
    label = "degrees",
)
DropShadow(
    color = Color.Black.copy(alpha = 0.5f),
    offset = DpOffset(4.dp, 4.dp),
    radius = 8.dp,
    drawInvalidationTrigger = { degrees },
) {
    Image(
        painter = painterResource(id = R.drawable.ic_android_black_24dp),
        contentDescription = null,
        modifier = Modifier
            .size(48.dp)
            .rotate(degrees),
        colorFilter = ColorFilter.tint(Color(0xFF3DDC84)),
    )
}
```

## BoxShadow

```kotlin
Box(
    modifier = Modifier
        .size(48.dp)
        .boxShadow(
            color = Color.Black.copy(alpha = 0.5f),
            offset = DpOffset(4.dp, 4.dp),
            radius = 8.dp,
        )
        .background(Color.Red)
)
```

# Compatibility

`compose-dropshadow` uses `DrawScope.draw` API newly introduced in Compose [`1.6.0-alpha01`](https://developer.android.com/jetpack/androidx/releases/compose-ui#1.6.0-alpha01).
Therefore, it requires Compose 1.6 or higher to work.

# License

```
Copyright 2023 Masatoshi Kubode

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
