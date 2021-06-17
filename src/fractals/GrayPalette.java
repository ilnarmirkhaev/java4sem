package fractals;

public class GrayPalette implements Palette {
    @Override
    public int colorize(double v) {
        /*
        Получаем целое значение от 0 до 255,
        которое будет отражать каждый из 3 основных цветов RGB схемы.
        Т.к. у нас оттенки серого, то красный, синий и
        зеленый должны быть в равных "концентрациях".
         */
        int a = (int)((1 - v) * 255);
        /*
        (1 - v) инвертирует цвета, т.к. цвета представленные в int
        чем ближе к 0, тем бледнее (0 = белый),
        а чем ближе к -16777215, тем темнее (-16777215 = черный).

        Итоговое значение int получаем сложением байтов, умноженных на а.
        Чтобы цвета были непрозрачными, необходим минус.
        В HEX за это отвечает первый байт (0xFFAABBCC)
         */
        return -((a * 256 * 256) + (a * 256) + a);
    }
}
