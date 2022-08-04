package JavaCoreHomeWork6;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient();

        // Экземпляр класса Request создается через Builder (см. паттерн проектирования "Строитель")
        Request request = new Request.Builder()
                .url("https://api.weather.yandex.ru/v2/forecast?lat=55.75396&lon=37.620393&extra=true")
                .header("X-Yandex-API-Key", "33b57ca9-a67a-46c7-88fc-f7feea9923e2")
                .build();

        // Получение объекта ответа от сервера
        Response response = client.newCall(request).execute();

        // Тело сообщения возвращается методом body объекта Response
        String data_json = response.body().string();
        System.out.println(data_json);
    }

}
