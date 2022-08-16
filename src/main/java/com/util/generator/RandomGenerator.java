package com.util.generator;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.math3.distribution.EnumeratedDistribution;
import org.apache.commons.math3.distribution.LogNormalDistribution;
import org.apache.commons.math3.util.Pair;

import javax.swing.text.MaskFormatter;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Author: Oliver
 */
@Slf4j
public class RandomGenerator {
  @SneakyThrows
  public static void main(String[] args) {
    final int numberOfLines = 224;
    final String pattern = "(###) ###-####";
//    generatePhoneNumbers(numberOfLines, pattern, 2);
//    generateCities(numberOfLines);
//    generateOccupation(numberOfLines);
    generateIncome(numberOfLines);
//    generateAge(numberOfLines);
//    generateEmail(numberOfLines);
  }

  private static void generateEmail(int numberOfLines) throws NoSuchAlgorithmException {
    List<String> endings = List.of("yahoo.ca", "outlook.com", "hotmail.com", "gmail.com", "msn.com", "icloud.com", "live.com", "yahoo.com");
    List<String> beginnings = List.of("barnetwang", "wilsonm", "gatorli", "wildixon", "harpes", "boftx", "bhima", "stakasa", "slaff", "alhajj", "gboss", "amaranth", "nachbaur", "jginspace", "flaviog", "thehuang124", "gommix", "durist", "sscorpio", "afeldspar", "carmena", "granboul", "euice", "skaufman", "rupak", "cliffordj", "jbuchana", "matloff", "cvrcek", "ilial", "meder", "bmidd", "nasor", "mxiao", "okroeger", "comdig", "lishoy", "jespley", "speeves", "osaru", "bryam", "ganter", "rafasgj", "jgmyers", "webinc", "esokullu", "landscape29380", "janneh", "neonatus", "fviegas", "mecchiel", "dbanarse", "storerm", "denton", "epeeist", "jgwang", "keijser", "pkilab", "bdbrown", "jaffe", "skoch", "mosses", "josephw", "isaacson", "chunzi", "tonyhe143", "ahmad", "fwitness", "dalamb", "greear", "jesse", "tangsh", "valdez", "hyper", "damian", "munson", "rhavyn", "jyoliver", "heewong23", "johnbob", "ramollin", "onestab", "solomon", "moxfulder", "mrobshaw", "imightb", "bjornk", "tubesteak", "burns", "muzzy", "kjetilk", "mcnihil", "warrior", "doormat", "haddawy", "vlefevre", "qrczak", "rfisher", "campware", "jonas", "njpayne", "shang", "szymansk", "bader", "wkrebs", "hmbrand", "gemmell", "uncled", "jdray", "treeves", "natepuri", "dieman", "sonnen", "farber", "amichalo", "dunstan", "gastown", "dcoppit", "pavel", "smpeters", "ijackson", "draper", "hachi", "lstein", "kannan", "ranasta", "djupedal", "dsowsy", "jfmulder", "skythe", "seano", "feamster", "fukuchi", "satch", "kaiser", "specprog", "jbailie", "cgreuter", "mchugh", "marnanel", "srour", "gravyface", "firstpr", "tmccarth", "naoya", "symbolic", "gward", "ghaviv", "guialbu", "schwaang", "grolschie", "danneng", "chrwin", "benanov", "majordick", "stecoop", "bogjobber", "fudrucker", "fatelk", "garland", "notaprguy", "drolsky", "citadel", "inico", "chronos", "godeke", "mlewan", "ebassi", "sacraver", "zilla", "intlprog", "mcmillan", "zeller", "geoffr", "alastair", "podmaster", "joehall", "malattia", "phizntrg", "library", "fangorn", "msloan", "psharpe", "aschmitz", "melnik", "nacho", "helger", "jandrese", "bradl");
    Random rand = SecureRandom.getInstanceStrong();
    for (int i = 0; i < numberOfLines; i++) {
      int endingIndex = rand.nextInt(endings.size());
      String ending = endings.get(endingIndex);
//      System.out.println(ending);
      int beginningIndex = rand.nextInt(beginnings.size());
      String beginning = beginnings.get(beginningIndex);
//      System.out.println(beginning);
      System.out.println(beginning + '@' + ending);
    }
  }

  private static void generateAge(int numberOfLines) throws NoSuchAlgorithmException {
    Random rand = SecureRandom.getInstanceStrong();
    final int MIN_AGE = 18;
    final int MAX_AGE = 68;
    for (int i = 0; i < numberOfLines; i++) {
      int age = MIN_AGE + rand.nextInt(MAX_AGE - MIN_AGE + 1);
      System.out.println(age);
    }
  }

  private static void generateIncome(int numberOfLines) throws NoSuchAlgorithmException {
    final int MIN_INCOME = 20000;
    final int MEAN_INCOME = 65000;
    final double scale = 0.0;
    final double shape = 0.75;
    LogNormalDistribution logNormal = new LogNormalDistribution(scale, shape);
    log.info("logNormal = " + logNormal);
    log.info("logNormal.getSupportLowerBound() = " + logNormal.getSupportLowerBound());
    log.info("logNormal.getSupportUpperBound() = " + logNormal.getSupportUpperBound());
    log.info("logNormal.getNumericalMean() = " + logNormal.getNumericalMean());
    log.info("logNormal.getNumericalVariance() = " + logNormal.getNumericalVariance());
    for (int i = 0; i < numberOfLines; i++) {
      double sample = logNormal.sample();
      double incomeDecimal = MIN_INCOME + sample / logNormal.getNumericalMean() * (MEAN_INCOME - MIN_INCOME);
//      System.out.println(incomeDecimal);
      long incomeLong = (long) incomeDecimal;
//      System.out.println(incomeLong);
      if(incomeLong < 10000) {
        incomeLong = incomeLong / 100 * 100;
      } else if(incomeLong < 100000) {
        incomeLong = incomeLong / 1000 * 1000;
      } else if(incomeLong < 1000000) {
        incomeLong = incomeLong / 10000 * 10000;
      }
      System.out.println(incomeLong);
    }
  }

  private static void generateOccupation(int numberOfLines) {
    final List<Pair<String, Double>> occupationsByWeights = List.of(
      new Pair<>("Office worker", 0.09),
      new Pair<>("Self-employed", 0.09),
      new Pair<>("Realtor", 0.13),
      new Pair<>("Auto Sales", 0.06),
      new Pair<>("Accountant", 0.06),
      new Pair<>("Student", 0.06),
      new Pair<>("IT related", 0.06),
      new Pair<>("Lanscaper", 0.01),
      new Pair<>("Cashier", 0.01),
      new Pair<>("Engineer related", 0.06),
      new Pair<>("Mortgage agent ", 0.06),
      new Pair<>("Retired", 0.06),
      new Pair<>("Teacher", 0.01),
      new Pair<>("Roofer", 0.01),
      new Pair<>("Contrator ", 0.04),
      new Pair<>("Cleaning staff", 0.01),
      new Pair<>("High Value ", 0.01),
      new Pair<>("Banking related", 0.06),
      new Pair<>("Mover", 0.01),
      new Pair<>("Advertising related ", 0.01),
      new Pair<>("CSR ", 0.01),
      new Pair<>("Gardener ", 0.01),
      new Pair<>("Manager ", 0.01),
      new Pair<>("Diector ", 0.01),
      new Pair<>("Doctor", 0.01),
      new Pair<>("Logistics", 0.01),
      new Pair<>("Owner of lanscaping", 0.01),
      new Pair<>("Owner of roof company", 0.01),
      new Pair<>("Owner of Small business ", 0.01)
    );
    EnumeratedDistribution<String> generator = new EnumeratedDistribution<>(occupationsByWeights);
    for (int i = 0; i < numberOfLines; i++) {
      String city = generator.sample();
      System.out.println(city);
    }
  }

  private static void generateCities(int numberOfLines) {
    final List<Pair<String, Double>> citiesByWeights = List.of(
      new Pair<>("North York", 0.16),
      new Pair<>("Toronto", 0.17),
      new Pair<>("Scarborough", 0.17),
      new Pair<>("Markham", 0.17),
      new Pair<>("Richmond Hill", 0.17),
      new Pair<>("Aurora", 0.06),
      new Pair<>("Newmarket", 0.03),
      new Pair<>("Mississauga", 0.02),
      new Pair<>("Oakville", 0.01),
      new Pair<>("Waterloo", 0.01),
      new Pair<>("Hamilton", 0.01),
      new Pair<>("Ottawa", 0.01),
      new Pair<>("Windsor", 0.01)
    );
    EnumeratedDistribution<String> generator = new EnumeratedDistribution<>(citiesByWeights);
    for (int i = 0; i < numberOfLines; i++) {
      String city = generator.sample();
      System.out.println(city);
    }
  }

  private static void generatePhoneNumbers(final int numberOfLines, final String pattern, final int lengthOfMaskingEnding) throws ParseException, NoSuchAlgorithmException {
    final List<Pair<Long, Double>> areasByWeights = List.of(
      new Pair<>(647L, 0.75),
      new Pair<>(416L, 0.20),
      new Pair<>(905L, 0.04),
      new Pair<>(519L, 0.01)
    );
    EnumeratedDistribution<Long> generator = new EnumeratedDistribution<>(areasByWeights);
    Random rand = SecureRandom.getInstanceStrong();
    final int MIN_PHONE_NUMBER = 1000000;
    final int MAX_PHONE_NUMBER = 9999999;
    for (int i = 0; i < numberOfLines; i++) {
      long areaCode = generator.sample() * 10000000L;
      long phoneNumber = areaCode + MIN_PHONE_NUMBER + rand.nextInt(MAX_PHONE_NUMBER - MIN_PHONE_NUMBER + 1);
      MaskFormatter formatter = new MaskFormatter(pattern);
      formatter.setValueContainsLiteralCharacters(false);
      String phoneNumberFormatted = formatter.valueToString(phoneNumber);
      System.out.println(phoneNumberFormatted.substring(0, phoneNumberFormatted.length() - lengthOfMaskingEnding) + "**");
    }
  }
}
