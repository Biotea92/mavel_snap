package com.marvel.snap.service;

import com.marvel.snap.domain.Card;
import com.marvel.snap.repository.CardRepository;
import com.marvel.snap.request.CardCreate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepository cardRepository;

    public void saveCard(CardCreate cardCreate) {
        Card card = Card.builder()
                .korName(cardCreate.getKorName())
                .engName(cardCreate.getEngName())
                .series(cardCreate.getSeries())
                .cost(cardCreate.getCost())
                .power(cardCreate.getPower())
                .build();

        cardRepository.save(card);
    }

    @PostConstruct
    public void register() {
        List<CardCreate> cards = new ArrayList<>();

        // 1풀
        cards.add(CardCreate.builder().engName("Gamora").korName("가모라").series(1).cost(5).power(7).build());
        cards.add(CardCreate.builder().engName("Groot").korName("그루트").series(1).cost(3).power(3).build());
        cards.add(CardCreate.builder().engName("Nightcrawler").korName("나이트크롤러").series(1).cost(1).power(2).build());
        cards.add(CardCreate.builder().engName("Namor").korName("네이머").series(1).cost(4).power(5).build());
        cards.add(CardCreate.builder().engName("Nova").korName("노바").series(1).cost(1).power(2).build());
        cards.add(CardCreate.builder().engName("Doctor Strange").korName("닥터 스트레인지").series(1).cost(3).power(3).build());
        cards.add(CardCreate.builder().engName("Devil Dinosaur").korName("데빌 다이노소어").series(1).cost(5).power(3).build());
        cards.add(CardCreate.builder().engName("Deathlok").korName("데스록").series(1).cost(3).power(5).build());
        cards.add(CardCreate.builder().engName("Domino").korName("도미노").series(1).cost(2).power(3).build());
        cards.add(CardCreate.builder().engName("Lady Sif").korName("레이디 시프").series(1).cost(3).power(4).build());
        cards.add(CardCreate.builder().engName("Rocket Raccoon").korName("로켓 라쿤").series(1).cost(1).power(2).build());
        cards.add(CardCreate.builder().engName("Lizard").korName("리저드").series(1).cost(2).power(5).build());
        cards.add(CardCreate.builder().engName("Mantis").korName("맨티스").series(1).cost(1).power(2).build());
        cards.add(CardCreate.builder().engName("Multiple man").korName("멀티플맨").series(1).cost(2).power(3).build());
        cards.add(CardCreate.builder().engName("Medusa").korName("메두사").series(1).cost(2).power(2).build());
        cards.add(CardCreate.builder().engName("Morph").korName("모프").series(1).cost(3).power(0).build());
        cards.add(CardCreate.builder().engName("Moon Girl").korName("문 걸").series(1).cost(4).power(4).build());
        cards.add(CardCreate.builder().engName("Mister Sinister").korName("미스터 시니스터").series(1).cost(2).power(2).build());
        cards.add(CardCreate.builder().engName("Mister Fantastic").korName("미스터 판타스틱").series(1).cost(3).power(2).build());
        cards.add(CardCreate.builder().engName("Misty Knight").korName("미스티 나이트").series(1).cost(1).power(2).build());
        cards.add(CardCreate.builder().engName("Blade").korName("블레이드").series(1).cost(1).power(3).build());
        cards.add(CardCreate.builder().engName("Blue Marvel").korName("블루 마블").series(1).cost(5).power(3).build());
        cards.add(CardCreate.builder().engName("Bishop").korName("비숍").series(1).cost(3).power(1).build());
        cards.add(CardCreate.builder().engName("Cyclops").korName("사이클롭스").series(1).cost(3).power(4).build());
        cards.add(CardCreate.builder().engName("Sentinel").korName("센티널").series(1).cost(2).power(3).build());
        cards.add(CardCreate.builder().engName("Sword Master").korName("소드 마스터").series(1).cost(3).power(6).build());
        cards.add(CardCreate.builder().engName("Shocker").korName("쇼커").series(1).cost(2).power(3).build());
        cards.add(CardCreate.builder().engName("Scarlet Witch").korName("스칼렛 위치").series(1).cost(2).power(3).build());
        cards.add(CardCreate.builder().engName("Squirrel Girl").korName("스쿼럴걸").series(1).cost(1).power(1).build());
        cards.add(CardCreate.builder().engName("Star-Lord").korName("스타로드").series(1).cost(2).power(2).build());
        cards.add(CardCreate.builder().engName("Strong Guy").korName("스트롱 가이").series(1).cost(4).power(4).build());
        cards.add(CardCreate.builder().engName("Spider-Woman").korName("스파이더우먼").series(1).cost(5).power(7).build());
        cards.add(CardCreate.builder().engName("Spectrum").korName("스펙트럼").series(1).cost(6).power(5).build());
        cards.add(CardCreate.builder().engName("The Thing").korName("씽").series(1).cost(4).power(6).build());
        cards.add(CardCreate.builder().engName("Armor").korName("아머").series(1).cost(2).power(3).build());
        cards.add(CardCreate.builder().engName("America Chavez").korName("아메리카 차베즈").series(1).cost(6).power(9).build());
        cards.add(CardCreate.builder().engName("Iron Fist").korName("아이언 피스트").series(1).cost(1).power(2).build());
        cards.add(CardCreate.builder().engName("Iron Man").korName("아이언맨").series(1).cost(5).power(0).build());
        cards.add(CardCreate.builder().engName("Ironheart").korName("아이언하트").series(1).cost(3).power(0).build());
        cards.add(CardCreate.builder().engName("Apocalypse").korName("아포칼립스").series(1).cost(6).power(8).build());
        cards.add(CardCreate.builder().engName("Angela").korName("안젤라").series(1).cost(2).power(0).build());
        cards.add(CardCreate.builder().engName("Ant Man").korName("앤트맨").series(1).cost(1).power(1).build());
        cards.add(CardCreate.builder().engName("Abomination").korName("어보미네이션").series(1).cost(5).power(9).build());
        cards.add(CardCreate.builder().engName("Angel").korName("엔젤").series(1).cost(1).power(2).build());
        cards.add(CardCreate.builder().engName("Elektra").korName("엘렉트라").series(1).cost(1).power(1).build());
        cards.add(CardCreate.builder().engName("Odin").korName("오딘").series(1).cost(6).power(8).build());
        cards.add(CardCreate.builder().engName("Onslaught").korName("온슬로트").series(1).cost(6).power(7).build());
        cards.add(CardCreate.builder().engName("Yondu").korName("욘두").series(1).cost(1).power(2).build());
        cards.add(CardCreate.builder().engName("Wolverine").korName("울버린").series(1).cost(2).power(3).build());
        cards.add(CardCreate.builder().engName("Wolfsbane").korName("울프스베인").series(1).cost(3).power(1).build());
        cards.add(CardCreate.builder().engName("Enchantress").korName("인챈트리스").series(1).cost(4).power(4).build());
        cards.add(CardCreate.builder().engName("Jessica Jones").korName("제시카 존스").series(1).cost(4).power(4).build());
        cards.add(CardCreate.builder().engName("Uatu the Watcher").korName("주시자 우아투").series(1).cost(1).power(2).build());
        cards.add(CardCreate.builder().engName("Carnage").korName("카니지").series(1).cost(2).power(2).build());
        cards.add(CardCreate.builder().engName("Ka-Zar").korName("카자르").series(1).cost(4).power(4).build());
        cards.add(CardCreate.builder().engName("Captain America").korName("캡틴 아메리카").series(1).cost(3).power(3).build());
        cards.add(CardCreate.builder().engName("Cable").korName("케이블").series(1).cost(2).power(2).build());
        cards.add(CardCreate.builder().engName("Korg").korName("코르그").series(1).cost(1).power(2).build());
        cards.add(CardCreate.builder().engName("Cosmo").korName("코스모").series(1).cost(3).power(3).build());
        cards.add(CardCreate.builder().engName("Colossus").korName("콜로서스").series(1).cost(2).power(3).build());
        cards.add(CardCreate.builder().engName("Quicksilver").korName("퀵실버").series(1).cost(1).power(2).build());
        cards.add(CardCreate.builder().engName("Kraven").korName("크레이븐").series(1).cost(2).power(2).build());
        cards.add(CardCreate.builder().engName("Klaw").korName("클로").series(1).cost(5).power(4).build());
        cards.add(CardCreate.builder().engName("Punisher").korName("퍼니셔").series(1).cost(3).power(2).build());
        cards.add(CardCreate.builder().engName("Forge").korName("포지").series(1).cost(2).power(1).build());
        cards.add(CardCreate.builder().engName("Professor X").korName("프로페서 X").series(1).cost(5).power(3).build());
        cards.add(CardCreate.builder().engName("Hulk").korName("헐크").series(1).cost(6).power(12).build());
        cards.add(CardCreate.builder().engName("Hulkbuster").korName("헐크버스터").series(1).cost(3).power(4).build());
        cards.add(CardCreate.builder().engName("Heimdall").korName("헤임달").series(1).cost(6).power(8).build());
        cards.add(CardCreate.builder().engName("Hawkeye").korName("호크아이").series(1).cost(1).power(1).build());
        cards.add(CardCreate.builder().engName("White Queen").korName("화이트 퀸").series(1).cost(4).power(6).build());
        cards.add(CardCreate.builder().engName("White Tiger").korName("화이트 타이거").series(1).cost(5).power(1).build());

        // 2풀
        cards.add(CardCreate.builder().engName("Nakia").korName("나키아").series(2).cost(3).power(1).build());
        cards.add(CardCreate.builder().engName("Rhino").korName("라이노").series(2).cost(3).power(3).build());
        cards.add(CardCreate.builder().engName("Leech").korName("리치").series(2).cost(5).power(3).build());
        cards.add(CardCreate.builder().engName("Morbius").korName("모비우스").series(2).cost(2).power(0).build());
        cards.add(CardCreate.builder().engName("Bucky Barnes").korName("버키 반스").series(2).cost(2).power(1).build());
        cards.add(CardCreate.builder().engName("Vulture").korName("벌처").series(2).cost(3).power(3).build());
        cards.add(CardCreate.builder().engName("Vision").korName("비전").series(2).cost(5).power(7).build());
        cards.add(CardCreate.builder().engName("Sandman").korName("샌드맨").series(2).cost(4).power(1).build());
        cards.add(CardCreate.builder().engName("Shang-Chi").korName("샹치").series(2).cost(4).power(3).build());
        cards.add(CardCreate.builder().engName("Sunspot").korName("선스팟").series(2).cost(1).power(1).build());
        cards.add(CardCreate.builder().engName("Sabretooth").korName("세이버투스").series(2).cost(3).power(4).build());
        cards.add(CardCreate.builder().engName("Swarm").korName("스웜").series(2).cost(2).power(3).build());
        cards.add(CardCreate.builder().engName("Scorpion").korName("스콜피온").series(2).cost(2).power(2).build());
        cards.add(CardCreate.builder().engName("Storm").korName("스톰").series(2).cost(3).power(2).build());
        cards.add(CardCreate.builder().engName("Iceman").korName("아이스맨").series(2).cost(1).power(2).build());
        cards.add(CardCreate.builder().engName("Ebony Maw").korName("에보니 모").series(2).cost(1).power(7).build());
        cards.add(CardCreate.builder().engName("Agent 13").korName("에이전트 13").series(2).cost(1).power(2).build());
        cards.add(CardCreate.builder().engName("Okoye").korName("오코예").series(2).cost(2).power(2).build());
        cards.add(CardCreate.builder().engName("Warpath").korName("워패스").series(2).cost(4).power(5).build());
        cards.add(CardCreate.builder().engName("The Infinaut").korName("인피너트").series(2).cost(6).power(20).build());
        cards.add(CardCreate.builder().engName("Jubilee").korName("주빌리").series(2).cost(4).power(1).build());
        cards.add(CardCreate.builder().engName("The Collector").korName("콜렉터").series(2).cost(2).power(1).build());
        cards.add(CardCreate.builder().engName("Cloak").korName("클록").series(2).cost(2).power(4).build());
        cards.add(CardCreate.builder().engName("Killmonger").korName("킬몽거").series(2).cost(3).power(3).build());
        cards.add(CardCreate.builder().engName("Hobgoblin").korName("홉고블린").series(2).cost(5).power(-8).build());

        // 3풀
        cards.add(CardCreate.builder().engName("Gambit").korName("갬빗").series(3).cost(3).power(1).build());
        cards.add(CardCreate.builder().engName("Ghost Rider").korName("고스트 라이더").series(3).cost(4).power(3).build());
        cards.add(CardCreate.builder().engName("Goose").korName("구스").series(3).cost(2).power(2).build());
        cards.add(CardCreate.builder().engName("Green Goblin").korName("그린 고블린").series(3).cost(3).power(-3).build());
        cards.add(CardCreate.builder().engName("Giganto").korName("기간토").series(3).cost(6).power(14).build());
        cards.add(CardCreate.builder().engName("Nick Fury").korName("닉 퓨리").series(3).cost(5).power(7).build());
        cards.add(CardCreate.builder().engName("Doctor Doom").korName("닥터 둠").series(3).cost(6).power(5).build());
        cards.add(CardCreate.builder().engName("Doctor Octopus").korName("닥터 옥토퍼스").series(3).cost(5).power(10).build());
        cards.add(CardCreate.builder().engName("Dagger").korName("대거").series(3).cost(2).power(1).build());
        cards.add(CardCreate.builder().engName("Deadpool").korName("데드풀").series(3).cost(1).power(1).build());
        cards.add(CardCreate.builder().engName("Debrii").korName("데브리").series(3).cost(3).power(3).build());
        cards.add(CardCreate.builder().engName("Death").korName("데스").series(3).cost(9).power(12).build());
        cards.add(CardCreate.builder().engName("Daredevil").korName("데어데블").series(3).cost(2).power(2).build());
        cards.add(CardCreate.builder().engName("Dracula").korName("드라큘라").series(3).cost(4).power(0).build());
        cards.add(CardCreate.builder().engName("Drax").korName("드랙스").series(3).cost(4).power(4).build());
        cards.add(CardCreate.builder().engName("Destroyer").korName("디스트로이어").series(3).cost(6).power(15).build());
        cards.add(CardCreate.builder().engName("Red Skull").korName("레드 스컬").series(3).cost(5).power(15).build());
        cards.add(CardCreate.builder().engName("Rescue").korName("레스큐").series(3).cost(4).power(4).build());
        cards.add(CardCreate.builder().engName("Rogue").korName("로그").series(3).cost(3).power(1).build());
        cards.add(CardCreate.builder().engName("Rockslide").korName("록슬라이드").series(3).cost(4).power(6).build());
        cards.add(CardCreate.builder().engName("Lockjaw").korName("록조").series(3).cost(3).power(2).build());
        cards.add(CardCreate.builder().engName("Leader").korName("리더").series(3).cost(6).power(4).build());
        cards.add(CardCreate.builder().engName("Maximus").korName("막시무스").series(3).cost(3).power(7).build());
        cards.add(CardCreate.builder().engName("Magneto").korName("매그니토").series(3).cost(6).power(12).build());
        cards.add(CardCreate.builder().engName("Magik").korName("매직").series(3).cost(5).power(3).build());
        cards.add(CardCreate.builder().engName("Baron Mordo").korName("모르도 남작").series(3).cost(2).power(3).build());
        cards.add(CardCreate.builder().engName("Mojo").korName("모조").series(3).cost(2).power(2).build());
        cards.add(CardCreate.builder().engName("Moon Knight").korName("문 나이트").series(3).cost(3).power(3).build());
        cards.add(CardCreate.builder().engName("Mister Negative").korName("미스터 네거티브").series(3).cost(4).power(-1).build());
        cards.add(CardCreate.builder().engName("Mysteio").korName("미스테리오").series(3).cost(2).power(4).build());
        cards.add(CardCreate.builder().engName("Mystique").korName("미스틱").series(3).cost(3).power(0).build());
        cards.add(CardCreate.builder().engName("Viper").korName("바이퍼").series(3).cost(2).power(3).build());
        cards.add(CardCreate.builder().engName("Venom").korName("베놈").series(3).cost(3).power(1).build());
        cards.add(CardCreate.builder().engName("Brood").korName("브루드").series(3).cost(3).power(2).build());
        cards.add(CardCreate.builder().engName("Black Bolt").korName("블랙 볼트").series(3).cost(5).power(8).build());
        cards.add(CardCreate.builder().engName("Black Widow").korName("블랙 위도우").series(3).cost(2).power(1).build());
        cards.add(CardCreate.builder().engName("Black Cat").korName("블랙 캣").series(3).cost(3).power(6).build());
        cards.add(CardCreate.builder().engName("Beast").korName("비스트").series(3).cost(2).power(2).build());
        cards.add(CardCreate.builder().engName("Psylocke").korName("사일록").series(3).cost(2).power(1).build());
        cards.add(CardCreate.builder().engName("Sera").korName("세라").series(3).cost(5).power(4).build());
        cards.add(CardCreate.builder().engName("Cerebro").korName("세레브로").series(3).cost(3).power(0).build());
        cards.add(CardCreate.builder().engName("Spider-Man").korName("스파이더맨").series(3).cost(4).power(3).build());
        cards.add(CardCreate.builder().engName("Adam Walock").korName("아담 워록").series(3).cost(2).power(0).build());
        cards.add(CardCreate.builder().engName("Arnim Zola").korName("아르님 졸라").series(3).cost(6).power(0).build());
        cards.add(CardCreate.builder().engName("Agatha Harkness").korName("애거사 하크니스").series(3).cost(6).power(14).build());
        cards.add(CardCreate.builder().engName("Aero").korName("에어로").series(3).cost(5).power(8).build());
        cards.add(CardCreate.builder().engName("Yellojacket").korName("옐로재킷").series(3).cost(0).power(2).build());
        cards.add(CardCreate.builder().engName("Omega Red").korName("오메가 레드").series(3).cost(4).power(5).build());
        cards.add(CardCreate.builder().engName("Wasp").korName("와스프").series(3).cost(0).power(1).build());
        cards.add(CardCreate.builder().engName("Ultron").korName("울트론").series(3).cost(6).power(8).build());
        cards.add(CardCreate.builder().engName("Wong").korName("웡").series(3).cost(4).power(2).build());
        cards.add(CardCreate.builder().engName("Wave").korName("웨이브").series(3).cost(3).power(3).build());
        cards.add(CardCreate.builder().engName("Invisible Woman").korName("인비저블우먼").series(3).cost(2).power(2).build());
        cards.add(CardCreate.builder().engName("Electro").korName("일렉트로").series(3).cost(3).power(2).build());
        cards.add(CardCreate.builder().engName("Juggernaut").korName("저거노트").series(3).cost(3).power(3).build());
        cards.add(CardCreate.builder().engName("Zero").korName("제로").series(3).cost(1).power(3).build());
        cards.add(CardCreate.builder().engName("Jane Foster Mighty Thor").korName("제인 포스터 마이티 토르").series(3).cost(5).power(8).build());
        cards.add(CardCreate.builder().engName("Ronan the Accuser").korName("집행관 로난").series(3).cost(5).power(3).build());
        cards.add(CardCreate.builder().engName("Captain Marvel").korName("캡틴 마블").series(3).cost(5).power(6).build());
        cards.add(CardCreate.builder().engName("Colleen Wing").korName("콜린 윙").series(3).cost(2).power(4).build());
        cards.add(CardCreate.builder().engName("Quake").korName("퀘이크").series(3).cost(2).power(3).build());
        cards.add(CardCreate.builder().engName("Quinjet").korName("퀸젯").series(3).cost(1).power(2).build());
        cards.add(CardCreate.builder().engName("Crossbones").korName("크로스본즈").series(3).cost(4).power(8).build());
        cards.add(CardCreate.builder().engName("Crystal").korName("크리스탈").series(3).cost(4).power(4).build());
        cards.add(CardCreate.builder().engName("Kingpin").korName("킹핀").series(3).cost(3).power(4).build());
        cards.add(CardCreate.builder().engName("Typhoid Mary").korName("타이포이드 메리").series(3).cost(4).power(10).build());
        cards.add(CardCreate.builder().engName("Taskmaster").korName("태스크마스터").series(3).cost(5).power(0).build());
        cards.add(CardCreate.builder().engName("Thor").korName("토르").series(3).cost(3).power(4).build());
        cards.add(CardCreate.builder().engName("Falcon").korName("팔콘").series(3).cost(2).power(3).build());
        cards.add(CardCreate.builder().engName("Patriot").korName("패트리어트").series(3).cost(3).power(1).build());
        cards.add(CardCreate.builder().engName("Polaris").korName("폴라리스").series(3).cost(3).power(5).build());
        cards.add(CardCreate.builder().engName("Hazmat").korName("해즈맷").series(3).cost(2).power(1).build());
        cards.add(CardCreate.builder().engName("Hela").korName("헬라").series(3).cost(6).power(6).build());
        cards.add(CardCreate.builder().engName("Hellcow").korName("헬카우").series(3).cost(4).power(6).build());
        cards.add(CardCreate.builder().engName("The Hood").korName("후드").series(3).cost(1).power(-2).build());
        cards.add(CardCreate.builder().engName("Human Torch").korName("휴먼 토치").series(3).cost(1).power(2).build());

        // 4풀
        cards.add(CardCreate.builder().engName("She-Hulk").korName("쉬헐크").series(4).cost(6).power(10).build());
        cards.add(CardCreate.builder().engName("Titania").korName("티타니아").series(4).cost(1).power(5).build());
        cards.add(CardCreate.builder().engName("Absorbing Man").korName("업소맨").series(4).cost(4).power(3).build());
        cards.add(CardCreate.builder().engName("Attuma").korName("아투마").series(4).cost(4).power(10).build());
        cards.add(CardCreate.builder().engName("Orka").korName("오르카").series(4).cost(6).power(9).build());
        cards.add(CardCreate.builder().engName("Agent Coulson").korName("에이전트 콜손").series(4).cost(3).power(4).build());
        cards.add(CardCreate.builder().engName("Luke Cage").korName("루크 케이지").series(4).cost(2).power(1).build());
        cards.add(CardCreate.builder().engName("Helicarrier").korName("핼리케리어").series(4).cost(6).power(10).build());
        cards.add(CardCreate.builder().engName("Maria Hill").korName("마리아 힐").series(4).cost(2).power(3).build());
        cards.add(CardCreate.builder().engName("M'Baku").korName("음바쿠").series(4).cost(1).power(2).build());

        // 5풀
        cards.add(CardCreate.builder().engName("Bast").korName("바스트").series(5).cost(1).power(1).build());
        cards.add(CardCreate.builder().engName("Galactus").korName("갤럭투스").series(5).cost(6).power(3).build());
        cards.add(CardCreate.builder().engName("Shuri").korName("쉬리").series(5).cost(4).power(2).build());
        cards.add(CardCreate.builder().engName("Super-Skrull").korName("슈퍼 스컬").series(5).cost(4).power(2).build());
        cards.add(CardCreate.builder().engName("Thanos").korName("타노스").series(5).cost(6).power(8).build());
        cards.add(CardCreate.builder().engName("Valkyrie").korName("발키리").series(5).cost(5).power(3).build());

        // 0풀
        cards.add(CardCreate.builder().engName("Miles Morales").korName("마일스 모랄레스").series(0).cost(4).power(5).build());
        cards.add(CardCreate.builder().engName("Black Panther").korName("블랙 팬서").series(0).cost(5).power(4).build());

        System.out.println("done");
        cards.forEach(this::saveCard);
    }
}
