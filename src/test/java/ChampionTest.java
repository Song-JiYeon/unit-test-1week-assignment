import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.junit.Assert.*;

public class ChampionTest {
    private List<Champion> championList = new ArrayList<Champion>();

    @Before
    public void setUp() {

        //5개의 챔피언 객체를 만듭니다.
        Champion topChamp = new Champion("다리우스", "탑");
        Champion jungleChamp = new Champion("리신", "정글");
        Champion midChamp = new Champion("르블랑", "미드");
        Champion adcChamp = new Champion("베인", "바텀");
        Champion supportChamp = new Champion("레오나", "바텀");

        //앞서 만든 List 에 각 챔피언을 추가합니다.
        championList.add(topChamp);
        championList.add(jungleChamp);
        championList.add(midChamp);
        championList.add(adcChamp);
        championList.add(supportChamp);
    }

    //List<String>을 생성하고 값이 비어 있는지를 테스트 empty()
    @Test
    public void givenCollectionWhenEmptyCorrect() {
        List<String> emptyList = new ArrayList<>();
        assertThat(emptyList, empty());
    }

    //notNullValue 활용한 테스트
    @Test
    public void notNullCheck() {
        String lck = "LCK";
        assertThat(lck, notNullValue());
    }

    //notNullValue 활용한 테스트 추가
    @Test
    public void notNullcheck1(){
        String str= "LeagueOfLegend";
        assertThat(str, notNullValue());
    }

    //nullValue 활용한 테스트
    @Test
    public void givenStringWhenNullIsCorrect() {
        String lck = null;
        assertThat(lck, nullValue());
    }

    //nullValue 활용한 테스트 추가
    @Test
    public void givenStringWhenNullIsCorrect1(){
        String str = null;
        assertThat(str, nullValue());
    }


    //문자열 관련 테스트 anyOf, containsString, endWith
    @Test
    public void testForRelatedString() {
        String sampleString1 = "Player Focus";
        String sampleString2 = "Player point";
        String startString = "Player";
        String endString = "point";

        assertThat(sampleString1, anyOf(startsWith(startString), containsString(endString)));
        assertThat(sampleString2, is(endsWith(endString)));
        assertThat(sampleString1, is(startsWith(startString)));
        assertThat(sampleString2, is(startsWith(startString)));

    }

    //문자열 관련 테스트 anyOf, containsString, endWith 추가
    @Test
    public void testForRelatedString1() {
        String sampleString3 = "Champion Rank";
        String sampleString4 = "Champion type";
        String startString = "Champion";
        String endString = "type";

        assertThat(sampleString3, anyOf(startsWith(startString), containsString(endString)));
        assertThat(sampleString3, is(startsWith(startString)));
        assertThat(sampleString4, is(startsWith(startString)));
        assertThat(sampleString4, is(endsWith(endString)));
    }

    //부동소수점 범위 closeTo 테스트
    @Test
    public void testForFloatingPoint() {
        assertThat(3.14, closeTo(3, 0.2));

    }

    //anything 테스트
    @Test
    public void shouldNotErrorGetReference() {
        assertThat(championList.get(0), anything());
        assertThat(championList.get(1), anything());
        assertThat(championList.get(2), anything());
        assertThat(championList.get(3), anything());
        assertThat(championList.get(4), anything()); //어떤 값이던 가져오면 test 통과

    }

    //객체 크기 검증 테스트 hasSize
    @Test
    public void shouldChampionCountFive() {
        assertTrue(championList.size() == 5); //실행 가능 이유? @before
        assertThat(championList.size(), is(5));
        assertThat(championList, hasSize(5));
        assertFalse(championList.size() == 10);

    }

    //서폿 챔피언은 타릭이어야 한다라는 조건으로 테스트 코드 작성
    @Test
    public void shouldSupportChampionIsTaric() {
        Champion supportChamp = new Champion("타릭", "바텀");
        assertThat("타릭", is(supportChamp.getName()));
        assertThat("타릭", is(equalTo(supportChamp.getName())));
        assertThat("타릭", equalTo(supportChamp.getName()));

    }

    //정글 챔피언은 리신이어야 한다라는 조건으로 테스트 코드 작성 추가
    @Test
    public void shouldJungleChampionIsLeeSin() {
        Champion jungleChamp = new Champion("리신", "정글");
        assertThat("리신", is(jungleChamp.getName()));
        assertThat("리신", is(equalTo(jungleChamp.getName())));
        assertThat("리신", equalTo(jungleChamp.getName()));
    }

    //hasProperty 활용하여 속성이 포함되어 있는지 테스트
    @Test
    public void shouldHasPropertyPosition() {
        assertThat(championList.get(0), hasProperty("position"));
        assertThat(championList.get(0), hasProperty("position",equalTo("탑")));
        assertThat(championList.get(0), hasProperty("name",equalTo("다리우스")));

        assertThat(championList.get(2), hasProperty("position"));
        assertThat(championList.get(2), hasProperty("position", equalTo("미드")));
        assertThat(championList.get(2), hasProperty("name",equalTo("르블랑")));

    }

    //hasToString 활용 테스트
    @Test
    public void shouldHaveSomeChampName() {
        List<String> champListNames = Arrays.asList("루시안", "애쉬", "렉사이", "갈리오", "모르가느", "블라디미르");
        assertThat(champListNames.get(0), hasToString("루시안"));
        assertThat(champListNames.get(1), hasToString("애쉬"));
        assertThat(champListNames.get(2), hasToString("렉사이"));

        List<String> positionNames = Arrays.asList("탑", "미드", "바텀", "정글");
        assertThat(positionNames.get(0), hasToString("탑"));
        assertThat(positionNames.get(1), hasToString("미드"));
        assertThat(positionNames.get(2), hasToString("바텀"));

    }

    //property와 value가 같은지 테스트
    @Test
    public void shouldHaveSamePropertyAndValue() {
        List<String> championNames1 = Arrays.asList("루시안", "애쉬", "렉사이", "갈리오", "모르가나", "블라디미르");
        List<String> championNames2 = Arrays.asList("루시안", "애쉬", "렉사이", "갈리오", "모르가나", "블라디미르");
        assertThat(championNames1, samePropertyValuesAs(championNames2));
        assertThat(championNames2, samePropertyValuesAs(championNames1));

        List<String> positionName1 = Arrays.asList("탑", "미드", "바텀", "정글");
        List<String> positionName2 = Arrays.asList("탑", "미드", "바텀", "정글");
        assertThat(positionName1, samePropertyValuesAs(positionName2));
        assertThat(positionName2, samePropertyValuesAs(positionName1));

    }

    //탑 챔피언은 다리우스여야 한다라는 조건으로 테스트 코드 작성, stream 활용예
    @Test
    public void shouldTopChampionIsDarius() {
        Optional<Champion> filterdChampion = championList.stream()
                .filter(c -> c.getPosition().equals("탑")) //position이 top인 것
                .findFirst();
        String champName = filterdChampion.get().getName(); //다리우스 이름 넣기
        assertTrue(champName.equals("다리우스"));
        assertThat("다리우스", is(champName));
    }

    //정글 챔피언은 리신이어야 한다라는 조건으로 테스트 코드 작성, stream 활용예 추가
    @Test
    public void shouldJungleChampionIsLeeSin1() {
        Optional<Champion> filterdChampion = championList.stream()
                .filter(c -> c.getPosition().equals("정글")) //position이 jungle인 것
                .findFirst();
        String champName = filterdChampion.get().getName(); //리신 이름 넣기
        assertTrue(champName.equals("리신"));
        assertThat("리신", is(champName));
    }

    //리신 챔피언은 정글 포지션이어야 한다는 조건으로 테스트 코드 작성, stream 활용예 추가
    @Test
    public void shouldLeeSinChampionIsJunglePosition() {
        Optional<Champion> filterdChampion = championList.stream()
                .filter(c -> c.getName().equals("리신")) //이름이 리신인 것
                .findFirst();
        String champPosition = filterdChampion.get().getPosition(); //정글 포지션 넣기
        assertTrue(champPosition.equals("정글"));
        assertThat("정글", is(champPosition));
    }

}