## Oembed Project

***

### ⚙️ Environment.

**Framework** : `Spring Boot`

**Packaging** : `jar`

**Language** : `java 11`

**Build Tool** : `Maven`

**Dependencies** : 
- `Lombok`
- `ThymeLeaf`
- `validation`
- `oembed-service` : **Open-Source** : Ref. 
<a href="https://github.com/michael-simons/java-oembed">https://github.com/michael-simons/java-oembed </a>

***

### 🔧 Installation.

```shell
mvn clean
mvn package
java -jar target/oembed-project-0.0.1-SNAPSHOT.jar
```

**Browser Access**
```shell
http://localhost:8080/
```

***

### 🚀 oEmbed 사용목적.

**oEmbed란?**

oEmbed는 공식사이트에 따르면, 다른 사이트의 URL을 내장된 표현이 가능하게 하는 `Format` 입니다.
유저가 `Resource`에 해당하는 링크를 입력할 때, 웹사이트들이 `Resource`를 직접 파싱하지 않고,
내장된 컨텐츠를 보여줄 수 있게 하는 간단한 `API`입니다.

**사용이유**
1. 각기 다른 프로바이더(`YouTube`, `twitter` 등)의 `embed API`를 신경쓰지 않아도 됩니다.
   - 프로바이더들 마다 각기 다른 `API` 요청을 표준화 시켜줄 수 있습니다.
2. 프로바이더가 다르더라도 정해진 포맷으로 전달 받을 수 있습니다.
    - `oEmbed`를 사용하지 않을 시, 각각의 프로바이더들의 `Response Data` 가 제각기 다릅니다.
    - `oEmbed`를 사용하게 되면 표준화된 데이터 포맷을 보내주기 때문에 더욱더 쉽게 데이터를 처리할 수 있습니다.
    
***

### 🚀 Instagram 을 사용하지 못하는 이유.

`Instagram` 은 21년 6월을 기준으로 `oEmbed`가 불가능하게 되었다고 합니다.
`oEmbed` 를 사용하기 위해서는 앱 검수를 통과 했을 때 사용이 가능하다고 합니다.

앱에 액세스할 수 없는 경우를 정리하자면,

1. 앱이 `Facebook` 약관과 정책을 준수하고 요청한 권한과 기능을 사용하는지 확인을 위해 앱을 제출하고 테스트 받아야합니다.
2. 앱이 아직 개발중인 경우, 검수가 불가능하기 때문에 사용이 반려된다고 합니다.
3. 현재 사용중인 기능에서만 `API` 요청이 가능하다고 합니다.
4. `Facebook` 에서 제공하는 로그인 정책과 `oAuth`를 사용하여 앱에서 `Facebook`을 통한 로그인이 가능해야 한다고 합니다.

***

### 🚀 Description.

**Core Business Logic**

1. 서버단에서 `oEmbed API`를 요청하기 위해 `Custom Http Client`를 만들었습니다.
   - connection pool 을 사용가능하도록 하였습니다.
   - connection 의 expired 시간을 설정하였습니다.
   - 만료된 connection을 회수하는 `Thread`를 정의하였습니다.
2. 오픈 소스를 활용하여 `oEmbed` 서비스를 빈으로 등록해 사용하였습니다.
3. `ThymeLeaf` 를 사용하여 `SSR` 을 적용하였습니다.
4. `Browser` 에서 요청하는 `Url`에 대하여 `Validation`을 적용하였습니다.

**Validation 적용 모습**

- `Url`을 입력하지 않았을 때
   <img width="80%" alt="스크린샷 2022-08-01 오후 2 50 45" src="https://user-images.githubusercontent.com/56334761/182080996-23f0c57e-f1ad-41eb-a76e-b95b04c4c4fa.png">
- `Url`이 유효하지 않을 때
   <img width="80%" alt="스크린샷 2022-08-01 오후 2 50 59" src="https://user-images.githubusercontent.com/56334761/182081007-db480926-2ac7-41b9-acbf-732584da5ad0.png">

***

### 🙋🏻‍♂️ Thank you!