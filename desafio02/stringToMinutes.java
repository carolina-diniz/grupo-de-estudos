
public class stringToMinutes {
  public int transformToTime(String rawInput) {
    rawInput = rawInput.toLowerCase().trim();


    if (rawInput.contains(":")) {
      String[] time = rawInput.split(":");
      int hours = convertToInteger(time[0]);
      int minutes = convertToInteger(time[1]);
      if (hours == -1 || minutes == -1) {
        return -1;
      }
      return hours * 60 + minutes;
    }

    if (rawInput.toLowerCase().contains(" e ")) {
      String[] time = rawInput.split(" e ");
      int hours = getTimer(time[0], "h");
      int minutes = getTimer(time[1], "m");
      return hours * 60 + minutes;
    }

    if (rawInput.split(" ").length == 2 || rawInput.split(" ").length == 4) {
      String[] time = rawInput.split(" ");
      int hours = getTimer(time[0] + " " + time[1], "h");
      int minutes = time.length > 2 ? getTimer(time[2] + " " + time[3], "m") : 0;

      if (hours == -1)
        hours = 0;
      if (minutes == -1)
        minutes = 0;

      return hours * 60 + minutes;
    }

    int hours = getTimer(rawInput, "h");
    int minutes = getTimer(rawInput, "m");

    return hours * 60 + minutes;
  }

  private static int getTimer(String input, String type) {
    input = input.trim().toLowerCase();

    String[] time;

    if (input.contains(" " + type)) {
      time = input.split(" " + type);
    } else if (input.contains(type)) {
      time = input.split(type);
    } else {
      return 0;
    }

    return convertToInteger(time[0]);
  }

  private static int convertToInteger(String input) {
    try {
      return Integer.parseInt(input);
    } catch (NumberFormatException e) {
      return -1;
    }
  }
}
