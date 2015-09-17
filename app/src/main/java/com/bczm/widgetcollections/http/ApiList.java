package com.bczm.widgetcollections.http;

/**
 *
 * @author：Jorge on 2015/9/17 12:42
 */
public class ApiList {
 /*************播放页面的 api 开始*************/
// {
//        进入播放页面的 10个推荐
//        Get 请求
//        http://api.icartoons.cn/v4/contents/guessenjoy?content_id=2S201507052200092708&type=1&sig=c8WUHBEOhIHHahor%2B2X%2BamyPaLnNLcsN4vbK2RJOHBFV8ae15TvCGZkStc6jZN3UAiKq39h8CcNW9HGJPNWp%2BnSuhaxKXNiwFtjYSiQD%2Bz0SuoBUWVi404gcn0q0rZ7ilGQIbFC8rw5CQcG4cKM9%2BTHDqsp4e4bxseMVTg5cacs%3D
//        {
//            "record_count": 10,
//                "items": [
//            {
//                "content_id": "2S201507082200092729",
//                    "content_type": "2",
//                    "title": "魔女猎人",
//                    "description": "故事讲述因涉嫌杀害物理学家海因茨·修奈达而遭到通缉的少女艾莉丝，不知何故被黑社会高价悬赏。赏金猎人娜蒂在墨西哥的乡间发现了艾莉丝，却因偶然的原委从其他猎人手中将她救下。",
//                    "cover": "http://img0.icartoons.cn/opftp/20150710/7504/201507082200092729/cover/web165x220.jpg?flow_flag=74559208&flow_type=1&flow_channel=api&dm_sid=1442463131280313184a128030188f97&trackid=1442463131280313184a128030188f97----&loginfo=74559208|68a0f6a3d862|4|68a0f6a3d862|000000000000000|68a0f6a3d862",
//                    "w_type": 0,
//                    "superscript": "",
//                    "author": "真下耕一",
//                    "lastupdate": null,
//                    "trackid": "1442463131280313184a128030188f97-c7---",
//                    "pic": "http://img0.icartoons.cn/spftp/temp/2015071609212700000075912542/720x405.jpg?flow_flag=74559208&flow_type=1&flow_channel=api&dm_sid=1442463131280313184a128030188f97&trackid=1442463131280313184a128030188f97----&loginfo=74559208|68a0f6a3d862|4|68a0f6a3d862|000000000000000|68a0f6a3d862"
//            },
//            {
//                "content_id": "2S201504272200092406",
//                    "content_type": "2",
//                    "title": "梦幻妖子",
//                    "description": "在远古时代，天女从天上来到人间沐浴。天女沐浴时把她的羽衣挂在一旁，可是羽衣却被拿走了。由于没有羽衣无法回到天上，天女只有留在人间。于是她嫁给拿走羽衣的男人，繁衍了后代。他们的后代也因此继承了天女的血统……",
//                    "cover": "http://img0.icartoons.cn/opftp/20150428/7504/201504272200092406/cover/web165x220.jpg?flow_flag=74559208&flow_type=1&flow_channel=api&dm_sid=1442463131280313184a128030188f97&trackid=1442463131280313184a128030188f97----&loginfo=74559208|68a0f6a3d862|4|68a0f6a3d862|000000000000000|68a0f6a3d862",
//                    "w_type": 0,
//                    "superscript": "",
//                    "author": "渡瀬悠宇",
//                    "lastupdate": null,
//                    "trackid": "1442463131280313184a128030188f97-c7---",
//                    "pic": "http://img0.icartoons.cn/opftp/20150428/7504/201504272200092406/cover/720x405.jpg?flow_flag=74559208&flow_type=1&flow_channel=api&dm_sid=1442463131280313184a128030188f97&trackid=1442463131280313184a128030188f97----&loginfo=74559208|68a0f6a3d862|4|68a0f6a3d862|000000000000000|68a0f6a3d862"
//            },
//            {
//                "content_id": "2S201506032200092634",
//                    "content_type": "2",
//                    "title": "搜神记",
//                    "description": "传说中的三皇五帝时代，随着天下公认的领袖神农氏的去世，金、木、水、火、土，五族群雄开始蠢蠢欲动。就在此波涛暗涌的动荡时代，一位少年横空出世，在机缘巧合下开始了一段惊心动魄的传奇历程。",
//                    "cover": "http://img0.icartoons.cn/opftp/20150604/7504/201506032200092634/cover/web165x220.jpg?flow_flag=74559208&flow_type=1&flow_channel=api&dm_sid=1442463131280313184a128030188f97&trackid=1442463131280313184a128030188f97----&loginfo=74559208|68a0f6a3d862|4|68a0f6a3d862|000000000000000|68a0f6a3d862",
//                    "w_type": 0,
//                    "superscript": "",
//                    "author": "杭州九越数字动画",
//                    "lastupdate": null,
//                    "trackid": "1442463131280313184a128030188f97-c7---",
//                    "pic": "http://img0.icartoons.cn/opftp/20150604/7504/201506032200092634/cover/720x405.jpg?flow_flag=74559208&flow_type=1&flow_channel=api&dm_sid=1442463131280313184a128030188f97&trackid=1442463131280313184a128030188f97----&loginfo=74559208|68a0f6a3d862|4|68a0f6a3d862|000000000000000|68a0f6a3d862"
//            },
//            {
//                "content_id": "2S201308022200088196",
//                    "content_type": "2",
//                    "title": "三目童子",
//                    "description": "故事讲述古代三眼族后裔写乐保介，是个天真烂漫的中学生，但他天生拥有三颗眼，而且拥有异于常人的超能力，只要把封印在第三颗眼上的胶布撕开，善良的写乐便会立即变成满脑子想着征服世界的狂人。而唯一能制止写乐变为恶魔的人，就是他的同学兼女友和登千代子",
//                    "cover": "http://img0.icartoons.cn/opftp/20130805/7504/201308022200088196/cover/web165x220.jpg?flow_flag=74559208&flow_type=1&flow_channel=api&dm_sid=1442463131280313184a128030188f97&trackid=1442463131280313184a128030188f97----&loginfo=74559208|68a0f6a3d862|4|68a0f6a3d862|000000000000000|68a0f6a3d862",
//                    "w_type": 0,
//                    "superscript": "",
//                    "author": "手冢治虫",
//                    "lastupdate": null,
//                    "trackid": "1442463131280313184a128030188f97-c7---",
//                    "pic": "http://img0.icartoons.cn/spftp/temp/2015051303355100000084112542/720x405.jpg?flow_flag=74559208&flow_type=1&flow_channel=api&dm_sid=1442463131280313184a128030188f97&trackid=1442463131280313184a128030188f97----&loginfo=74559208|68a0f6a3d862|4|68a0f6a3d862|000000000000000|68a0f6a3d862"
//            },
//            {
//                "content_id": "2S201501152200091741",
//                    "content_type": "2",
//                    "title": "黑之契约者第一季",
//                    "description": "被称为地狱门的不可侵领域突然出现在东京。 真正的星空消失，取而代之的是虚假的星星。世界各地开始出现被称为“契约者”的超能力者。",
//                    "cover": "http://img0.icartoons.cn/opftp/20150116/129600/201501152200091741/cover/web165x220.jpg?flow_flag=74559208&flow_type=1&flow_channel=api&dm_sid=1442463131280313184a128030188f97&trackid=1442463131280313184a128030188f97----&loginfo=74559208|68a0f6a3d862|4|68a0f6a3d862|000000000000000|68a0f6a3d862",
//                    "w_type": 0,
//                    "superscript": "",
//                    "author": "骨头社",
//                    "lastupdate": null,
//                    "trackid": "1442463131280313184a128030188f97-c7---",
//                    "pic": "http://img0.icartoons.cn/spftp/temp/2015091102502300000090813215/720x405.jpg?flow_flag=74559208&flow_type=1&flow_channel=api&dm_sid=1442463131280313184a128030188f97&trackid=1442463131280313184a128030188f97----&loginfo=74559208|68a0f6a3d862|4|68a0f6a3d862|000000000000000|68a0f6a3d862"
//            },
//            {
//                "content_id": "2S201501282200091818",
//                    "content_type": "2",
//                    "title": "魔笛MAGI第一季",
//                    "description": "作品中的登场人物名字部分取材于《一千零一夜》，舞台是与欧亚大陆和非洲相似的架空世界。故事主要讲述了作为选定世界之王的“魔奇”之一的小主人公阿拉丁，由此而展开的一系列有趣惊险的冒险旅程。\r\n",
//                    "cover": "http://img0.icartoons.cn/opftp/20150129/129600/201501282200091818/cover/web165x220.jpg?flow_flag=74559208&flow_type=1&flow_channel=api&dm_sid=1442463131280313184a128030188f97&trackid=1442463131280313184a128030188f97----&loginfo=74559208|68a0f6a3d862|4|68a0f6a3d862|000000000000000|68a0f6a3d862",
//                    "w_type": 0,
//                    "superscript": "",
//                    "author": "大高忍",
//                    "lastupdate": null,
//                    "trackid": "1442463131280313184a128030188f97-c7---",
//                    "pic": "http://img0.icartoons.cn/spftp/temp/2015081210145300000021513215/魔笛1.jpg?flow_flag=74559208&flow_type=1&flow_channel=api&dm_sid=1442463131280313184a128030188f97&trackid=1442463131280313184a128030188f97----&loginfo=74559208|68a0f6a3d862|4|68a0f6a3d862|000000000000000|68a0f6a3d862"
//            },
//            {
//                "content_id": "2S201501232200091794",
//                    "content_type": "2",
//                    "title": "魔笛MAGI第二季",
//                    "description": "作品中的登场人物名字部分取材于《一千零一夜》，舞台是与欧亚大陆和非洲相似的架空世界。故事主要讲述了作为选定世界之王的“魔奇”之一的小主人公阿拉丁，由此而展开的一系列有趣惊险的冒险旅程。",
//                    "cover": "http://img0.icartoons.cn/opftp/20150123/129600/201501232200091794/cover/web165x220.jpg?flow_flag=74559208&flow_type=1&flow_channel=api&dm_sid=1442463131280313184a128030188f97&trackid=1442463131280313184a128030188f97----&loginfo=74559208|68a0f6a3d862|4|68a0f6a3d862|000000000000000|68a0f6a3d862",
//                    "w_type": 0,
//                    "superscript": "",
//                    "author": "大高忍",
//                    "lastupdate": null,
//                    "trackid": "1442463131280313184a128030188f97-c7---",
//                    "pic": "http://img0.icartoons.cn/spftp/temp/2015042310422700000098313215/720x405.jpg?flow_flag=74559208&flow_type=1&flow_channel=api&dm_sid=1442463131280313184a128030188f97&trackid=1442463131280313184a128030188f97----&loginfo=74559208|68a0f6a3d862|4|68a0f6a3d862|000000000000000|68a0f6a3d862"
//            },
//            {
//                "content_id": "2S201306062200087595",
//                    "content_type": "2",
//                    "title": "魔笛MAGI",
//                    "description": "故事主要讲述了作为选定世界之王的“魔奇”之一的小主人公阿拉丁的一系列有趣惊险的冒险旅程。",
//                    "cover": "http://img0.icartoons.cn/opftp/20130607/129600/201306062200087595/cover/web165x220.jpg?flow_flag=74559208&flow_type=1&flow_channel=api&dm_sid=1442463131280313184a128030188f97&trackid=1442463131280313184a128030188f97----&loginfo=74559208|68a0f6a3d862|4|68a0f6a3d862|000000000000000|68a0f6a3d862",
//                    "w_type": 0,
//                    "superscript": "",
//                    "author": "大高忍",
//                    "lastupdate": null,
//                    "trackid": "1442463131280313184a128030188f97-c7---",
//                    "pic": "http://img0.icartoons.cn/spftp/temp/2015082810084700000017813228/720x405.jpg?flow_flag=74559208&flow_type=1&flow_channel=api&dm_sid=1442463131280313184a128030188f97&trackid=1442463131280313184a128030188f97----&loginfo=74559208|68a0f6a3d862|4|68a0f6a3d862|000000000000000|68a0f6a3d862"
//            },
//            {
//                "content_id": "2S201408192200091001",
//                    "content_type": "2",
//                    "title": "圣枪修女",
//                    "description": "年幼时的萝塞特一次不慎和弟弟尤休亚一起掉入墓穴，与自称是恶魔的克罗诺相遇，她与弟弟从此与克罗诺之间建立了绝对的信赖关系。。",
//                    "cover": "http://img0.icartoons.cn/opftp/20141015/5907/201408192200091001/cover/web165x220.jpg?flow_flag=74559208&flow_type=1&flow_channel=api&dm_sid=1442463131280313184a128030188f97&trackid=1442463131280313184a128030188f97----&loginfo=74559208|68a0f6a3d862|4|68a0f6a3d862|000000000000000|68a0f6a3d862",
//                    "w_type": 0,
//                    "superscript": "",
//                    "author": "NTV",
//                    "lastupdate": null,
//                    "trackid": "1442463131280313184a128030188f97-c7---",
//                    "pic": "http://img0.icartoons.cn/spftp/temp/2015082504342600000096313228/720x405.jpg?flow_flag=74559208&flow_type=1&flow_channel=api&dm_sid=1442463131280313184a128030188f97&trackid=1442463131280313184a128030188f97----&loginfo=74559208|68a0f6a3d862|4|68a0f6a3d862|000000000000000|68a0f6a3d862"
//            },
//            {
//                "content_id": "2S201504152200092350",
//                    "content_type": "2",
//                    "title": "血族",
//                    "description": "总是幻想着成为吸血鬼猎人的夜壬，意外地被卷入血族少女与圣地的激战之中开始。成为临时血仆的夜壬，并不知道自己所将要面对的，是一段绵延千年的仇恨与争斗……",
//                    "cover": "http://img0.icartoons.cn/opftp/20150819/129591/201504152200092350/cover/web165x220.jpg?flow_flag=74559208&flow_type=1&flow_channel=api&dm_sid=1442463131280313184a128030188f97&trackid=1442463131280313184a128030188f97----&loginfo=74559208|68a0f6a3d862|4|68a0f6a3d862|000000000000000|68a0f6a3d862",
//                    "w_type": 0,
//                    "superscript": "",
//                    "author": "杭州九漫信息技术有限公司",
//                    "lastupdate": null,
//                    "trackid": "1442463131280313184a128030188f97-c7---",
//                    "pic": "http://img0.icartoons.cn/opftp/20150819/129591/201504152200092350/cover/血族_副本.jpg?flow_flag=74559208&flow_type=1&flow_channel=api&dm_sid=1442463131280313184a128030188f97&trackid=1442463131280313184a128030188f97----&loginfo=74559208|68a0f6a3d862|4|68a0f6a3d862|000000000000000|68a0f6a3d862"
//            }
//            ]
//        }
//
//        -----------------------------------------------------------------------------------------
//        播放 视频
//
//        http://api.icartoons.cn/v4/contents/resource?trackid=1442463131280313184a128030188f97-c1-2-3-&serial_id=2S201507052200092708&content_id=2C201507053200190282&is_download=0&sig=fdYPAjJTDP78gGIwTNhQLrvKLFi3B91WhXEH9nyAZ6fFMco68n%2BnkkJ5HJoEdUwr0Ak74wcyL0SbevAJyGriEPaewbOTQxr9YUB87yHj1GYcEsW4bIqRXGY427tiKWkffjUSPXfsyMzNKvLB41nBoPKeiunwE%2Fe2%2BM7i9PIjeNA%3D

//
//
//
//        {
//            "title": "六花的勇者 第1集",
//                "totalcount": 1430,
//                "baseurl": "",
//                "items": [
//            {
//                "content_id": "2C201507053200190282",
//                    "set_num": "1",
//                    "url": "http://streaming-http.icartoons.cn:7388/cmstest/20150725/7504/201507053200190282/W1280.3gp?msisdn=74559208&spid=001&sid=005&appid=dm_zk_6001100_10069_30&trackid=1442463131280313184a128030188f97-c1-2-3-&dm_sid=1442463131280313184a128030188f97&loginfo=74559208|68a0f6a3d862|4|68a0f6a3d862|000000000000000|68a0f6a3d862&client_style=1&animeversion=j",
//                    "page": 1,
//                    "single_filesize": "141251350",
//                    "width": null,
//                    "height": null
//            }
//            ],
//            "provision": "W1280",
//                "filesize": 141251350,
//                "serial_title": "六花的勇者",
//                "next_chapter_id": "2C201507123200190855"
//        }
//
//
//
//
//
//        ------------------------------------------------
//        视频介绍
//        http://api.icartoons.cn/v4/contents/detail?trackid=1442463131280313184a128030188f97-c1-2-3-&content_id=2S201507052200092708&sig=ZkgO8wZFeeQhd0Rwbvglydd9KVr1Ajv%2FEV9vaUKkMeXAVJPzWkzj98T80vpTzZSw%2FRiRdbmNZ87nhFFPOp2Pj%2B3xTaFzwT31VyTx0l5hWi0obAT4f2apPKL8Hn4XmSxmizSb5NwSxk1m%2FKmMifBbK5pQ4j0g8kaFa6OEVj6O14g%3D
//
//                [
//        {
//            "content_id": "2S201507052200092708",
//                "content_type": "2",
//                "category_id": "32",
//                "category_name": "神魔",
//                "title": "六花的勇者",
//                "is_out_show": 0,
//                "description": "【爱动漫日漫新番同步首发】传说，当魔物从黑暗深渊觉醒，世间化为地狱之时，命运之神会选出六位勇者并将授予此六人拯救世界之力。现在开始所要讲述的，便是背负着拯救世界使命的勇者们的故事。",
//                "cover": "http://img0.icartoons.cn/opftp/20150706/7504/201507052200092708/cover/web165x220.jpg",
//                "lastupdate": "1436173194",
//                "is_fav": 0,
//                "author": "山形石雄",
//                "is_whb": "0",
//                "trackid": "1442463131280313184a128030188f97-c1-2-3-",
//                "serial_status": "0",
//                "is_continue": 0,
//                "continue_id": "",
//                "update_set": "11",
//                "is_sort": 1,
//                "is_down": 0,
//                "pic": "http://img0.icartoons.cn/spftp/temp/2015070610364100000062612542/720x405.jpg"
//        }
//        ]
//
//
//                ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//        评论
//        http://api.icartoons.cn/v4/user/comment_list?pagesize=12&page=0&content_id=2S201507052200092708&sig=uHqhqUsg2Iwb5BhPs5n7LLCDIkptz4SqXpQKzmlowdAvI0nRFuI0GoITT2dWL2PfO3edhun%2Bq%2BJNEuSvgGNaqaO%2BHR7%2F0Y4iXUyfc8wIKevkVBs7hZdT35moSKfoWuf8uDDbJJuile7amYoTC0v09aFSKRhEGOO5p63UOEpI%2Fzw%3D
//
//        {
//            "recordcount": 178,
//                "items": [
//            {
//                "id": "84901-1",
//                    "text": "人物画的很好，可以教我吗？",
//                    "userid": "73233266",
//                    "nickname": "qq0_薰衣草-等待爱情7",
//                    "create_time": "1438173954",
//                    "reply_num": "0",
//                    "photo": "http://api.icartoons.cn/user_image//20150728/2781208e-8966-e82c-08f5-d8e03c38dd59.png",
//                    "reply_uid": "0"
//            },
//            {
//                "id": "104964-1",
//                    "text": "挺好看的",
//                    "userid": "74694075",
//                    "nickname": "漫友 ☞ 千落",
//                    "create_time": "1442460946",
//                    "reply_num": "0",
//                    "photo": "http://api.icartoons.cn/user_image//20150912/f2ceb1d4-fe29-c9af-98bf-b69c2772d59d.png",
//                    "reply_uid": "0"
//            },
//            {
//                "id": "104765-1",
//                    "text": "攻击力了",
//                    "userid": "74785366",
//                    "nickname": "游客212644",
//                    "create_time": "1442327426",
//                    "reply_num": "0",
//                    "photo": "",
//                    "reply_uid": "0"
//            },
//            {
//                "id": "104612-1",
//                    "text": "多种简直 总有一种适合你  加我了解一下 又何妨  2412-70-9118",
//                    "userid": "74767765",
//                    "nickname": "漫友1509151635",
//                    "create_time": "1442274161",
//                    "reply_num": "0",
//                    "photo": "http://api.icartoons.cn/user_image//20150915/648e1cc9-3aca-9511-b5dc-a28948a81166.png",
//                    "reply_uid": "0"
//            },
//            {
//                "id": "104108-1",
//                    "text": "想做**的加我qq2451538661",
//                    "userid": "74700324",
//                    "nickname": "漫友1509123204",
//                    "create_time": "1442121749",
//                    "reply_num": "0",
//                    "photo": "http://api.icartoons.cn/user_image//20150912/270093b4-6057-1550-2034-d869883e36b7.png",
//                    "reply_uid": "0"
//            },
//            {
//                "id": "103892-1",
//                    "text": "吣甩曱",
//                    "userid": "70064632",
//                    "nickname": "dm_rmfhhvsliu",
//                    "create_time": "1442099117",
//                    "reply_num": "0",
//                    "photo": "",
//                    "reply_uid": "0"
//            },
//            {
//                "id": "103890-1",
//                    "text": "旨在恿月十凡事",
//                    "userid": "70064632",
//                    "nickname": "dm_rmfhhvsliu",
//                    "create_time": "1442099077",
//                    "reply_num": "0",
//                    "photo": "",
//                    "reply_uid": "0"
//            },
//            {
//                "id": "103625-1",
//                    "text": "不错不错，蛮好看的",
//                    "userid": "74658515",
//                    "nickname": "游客163707",
//                    "create_time": "1442063447",
//                    "reply_num": "0",
//                    "photo": "",
//                    "reply_uid": "0"
//            },
//            {
//                "id": "103514-1",
//                    "text": "做外宣就加我1434870127",
//                    "userid": "74700348",
//                    "nickname": "漫友1509126008",
//                    "create_time": "1442061421",
//                    "reply_num": "0",
//                    "photo": "http://api.icartoons.cn/user_image//20150912/96b10b19-f25a-b372-e71c-91caec9ed872.png",
//                    "reply_uid": "0"
//            },
//            {
//                "id": "103304-1",
//                    "text": "好看",
//                    "userid": "74682105",
//                    "nickname": "游客173060",
//                    "create_time": "1442032983",
//                    "reply_num": "0",
//                    "photo": "",
//                    "reply_uid": "0"
//            },
//            {
//                "id": "103080-1",
//                    "text": "**xxx",
//                    "userid": "73143406",
//                    "nickname": "aubdx521co70",
//                    "create_time": "1441966459",
//                    "reply_num": "0",
//                    "photo": "",
//                    "reply_uid": "0"
//            },
//            {
//                "id": "102981-1",
//                    "text": "誠召网，上謙耳只小說手稿打字員，適合学生，宝妈，学生**做，没两千字，2o元，以此类推，每天收入8o-2oo元不等！手机电脑做！时间自由安排，多劳多得，有意＋【扣】②⑥⑧⑤-①③①③-⑨②",
//                    "userid": "74640330",
//                    "nickname": "誠召打字員",
//                    "create_time": "1441902500",
//                    "reply_num": "0",
//                    "photo": "http://api.icartoons.cn/user_image//20150911/1b95b383-1a7e-3fd9-c63a-d4d839ea1cb6.jpg",
//                    "reply_uid": "0"
//            }
//            ]
//        }
//
//        ------------------------------------------------------------------------------------------------
//
//        当前视频的 其他 集
//        http://api.icartoons.cn/v4/contents/serials?start=0&outer_siteid=0&content_id=2S201507052200092708&limit=32767&sig=QiArSgGgYX%2BBb1kIzHzW9jEUfT2zMe4hwim95ktZL4XL9DNtutaTokbMyL8%2F3N5WucuQA6DowsdV4mdEuWQeuYZEcB4kwHjsRQU3AYZUl8jbK9TTTIQG10A2TNugWGEd6dY5eaL42B%2BM12v2ToAzGQVzIf1Q9X3e0xhGLVc5JLw%3D
//
//
//        {
//            "record_num": 11,
//                "items": [
//            {
//                "content_id": "2C201507053200190282",
//                    "title": "六花的勇者 第1集",
//                    "set_num": "1",
//                    "is_free": 1,
//                    "url": "http://192.168.26.75:18889/dm189/index.php?m=content&c=index&a=play_anime&id=200092708&provisionid=200359898",
//                    "lastupdate": "1437834301",
//                    "heght": "240",
//                    "width": "320",
//                    "is_new": 0
//            },
//            {
//                "content_id": "2C201507123200190855",
//                    "title": "六花的勇者 第2集",
//                    "set_num": "2",
//                    "is_free": 1,
//                    "url": "http://192.168.26.75:18889/dm189/index.php?m=content&c=index&a=play_anime&id=200092708&provisionid=200360630",
//                    "lastupdate": "1437986241",
//                    "heght": "240",
//                    "width": "320",
//                    "is_new": 0
//            },
//            {
//                "content_id": "2C201507193200191440",
//                    "title": "六花的勇者 第3集",
//                    "set_num": "3",
//                    "is_free": 1,
//                    "url": "http://192.168.26.75:18889/dm189/index.php?m=content&c=index&a=play_anime&id=200092708&provisionid=200361451",
//                    "lastupdate": "1438147950",
//                    "heght": "240",
//                    "width": "320",
//                    "is_new": 0
//            },
//            {
//                "content_id": "2C201507263200192281",
//                    "title": "六花的勇者 第4集",
//                    "set_num": "4",
//                    "is_free": 1,
//                    "url": "http://192.168.26.75:18889/dm189/index.php?m=content&c=index&a=play_anime&id=200092708&provisionid=200362509",
//                    "lastupdate": "1438665606",
//                    "heght": "240",
//                    "width": "320",
//                    "is_new": 0
//            },
//            {
//                "content_id": "2C201508023200192866",
//                    "title": "六花的勇者 第5集",
//                    "set_num": "5",
//                    "is_free": 1,
//                    "url": "http://192.168.26.75:18889/dm189/index.php?m=content&c=index&a=play_anime&id=200092708&provisionid=200363313",
//                    "lastupdate": "1439198925",
//                    "heght": "240",
//                    "width": "320",
//                    "is_new": 0
//            },
//            {
//                "content_id": "2C201508093200193414",
//                    "title": "六花的勇者 第6集",
//                    "set_num": "6",
//                    "is_free": 0,
//                    "url": "http://192.168.26.75:18889/dm189/index.php?m=content&c=index&a=play_anime&id=200092708&provisionid=200364124",
//                    "lastupdate": "1439549663",
//                    "heght": "240",
//                    "width": "320",
//                    "is_new": 0
//            },
//            {
//                "content_id": "2C201508153200193857",
//                    "title": "六花的勇者 第7集",
//                    "set_num": "7",
//                    "is_free": 0,
//                    "url": "http://192.168.26.75:18889/dm189/index.php?m=content&c=index&a=play_anime&id=200092708&provisionid=200364801",
//                    "lastupdate": "1440051380",
//                    "heght": "240",
//                    "width": "320",
//                    "is_new": 0
//            },
//            {
//                "content_id": "2C201508223200194218",
//                    "title": "六花的勇者 第8集",
//                    "set_num": "8",
//                    "is_free": 0,
//                    "url": "http://192.168.26.75:18889/dm189/index.php?m=content&c=index&a=play_anime&id=200092708&provisionid=200365289",
//                    "lastupdate": "1441519095",
//                    "heght": "240",
//                    "width": "320",
//                    "is_new": 0
//            },
//            {
//                "content_id": "2C201508293200194522",
//                    "title": "六花的勇者 第9集",
//                    "set_num": "9",
//                    "is_free": 0,
//                    "url": "http://192.168.26.75:18889/dm189/index.php?m=content&c=index&a=play_anime&id=200092708&provisionid=200365973",
//                    "lastupdate": "1442209626",
//                    "heght": "240",
//                    "width": "320",
//                    "is_new": 0
//            },
//            {
//                "content_id": "2C201509053200194635",
//                    "title": "六花的勇者 第10集",
//                    "set_num": "10",
//                    "is_free": 0,
//                    "url": "http://192.168.26.75:18889/dm189/index.php?m=content&c=index&a=play_anime&id=200092708&provisionid=200366194",
//                    "lastupdate": "1442210554",
//                    "heght": "240",
//                    "width": "320",
//                    "is_new": 0
//            },
//            {
//                "content_id": "2C201509123200194855",
//                    "title": "六花的勇者 第11集",
//                    "set_num": "11",
//                    "is_free": 0,
//                    "url": "http://192.168.26.75:18889/dm189/index.php?m=content&c=index&a=play_anime&id=200092708&provisionid=200366775",
//                    "lastupdate": "1442362701",
//                    "heght": "240",
//                    "width": "320",
//                    "is_new": 0
//            }
//            ],
//            "out_type": 0,
//                "out_source": [
//            {
//                "source_name": ""
//            }
//            ]
//        }
//
//        ------------------------------------------------------------------------------------------------------------------
//        视频清晰度
//
//        http://api.icartoons.cn/v4/contents/provisions?content_id=2C201509123200194855&sig=p1Pst11J6l3Srx%2BR3iZd%2BQEGTmKa81r%2BUcH%2BVftLmBMb91J%2FhKYNJ7a%2FLoWGUheOnmB5aNw%2BlZ%2FAPj94lH5LchAL9bSrzKVpyTEgeUUjb%2Bu3kA1ZSD1f%2F4WRqk3WijZBxYzhc%2BWcHk0EXMUUy6PvyZp4qigr9egRBeMxlkQy4XM%3D
//
//                [
//        {
//            "title": "超清",
//                "provision": "W1280",
//                "is_free": 0,
//                "point": 1
//        },
//        {
//            "title": "高清",
//                "provision": "W704",
//                "is_free": 0,
//                "point": 1
//        },
//        {
//            "title": "标清",
//                "provision": "W352",
//                "is_free": 0,
//                "point": 1
//        },
//        {
//            "title": "流畅",
//                "provision": "050MP4QCIF",
//                "is_free": 0,
//                "point": 1
//        }
//        ]
//                -------------------------------------------
//        切换清晰度
//
//        http://api.icartoons.cn/v4/contents/resource?provision=W1280&trackid=1442463131280313184a128030188f97-c1-2-3-&serial_id=2S201507052200092708&content_id=2C201507053200190282&is_download=0&sig=gzoFpw5WalI2EJxVJICqlb8T%2FPWsB8VNJxgK0Prj5YJB%2Fm%2F2DAqdvXCJLjlgZnHon5vgSkSGD1SWwanj3443UK8Ujui9FI90OkvFjL4cqq0wvIWkb82TO9rSkRiNnoA74blZi1z1U5qjTmwammWIyUtamM9m%2F%2BQ6B2HW51gr844%3D
//
//        {
//            "title": "六花的勇者 第1集",
//                "totalcount": 1430,
//                "baseurl": "",
//                "items": [
//            {
//                "content_id": "2C201507053200190282",
//                    "set_num": "1",
//                    "url": "http://streaming-http.icartoons.cn:7388/cmstest/20150725/7504/201507053200190282/W1280.3gp?msisdn=74559208&spid=001&sid=005&appid=dm_zk_6001100_10069_30&trackid=1442463131280313184a128030188f97-c1-2-3-&dm_sid=1442463131280313184a128030188f97&loginfo=74559208|68a0f6a3d862|4|68a0f6a3d862|000000000000000|68a0f6a3d862&client_style=1&animeversion=j",
//                    "page": 1,
//                    "single_filesize": "141251350",
//                    "width": null,
//                    "height": null
//            }
//            ],
//            "provision": "W1280",
//                "filesize": 141251350,
//                "serial_title": "六花的勇者",
//                "next_chapter_id": "2C201507123200190855"
//        }
//
//        ---------
//        {
//            "title": "小羊肖恩 全1集",
//                "totalcount": 5100,
//                "baseurl": "",
//                "items": [
//            {
//                "content_id": "2C201509043200194632",
//                    "set_num": "1",
//                    "url": "http://streaming-http.icartoons.cn:7388/cmstest/20150907/129525/201509043200194632/W704.3gp?msisdn=74559208&spid=001&sid=005&appid=dm_zk_6001100_10069_30&trackid=1442463131280313184a128030188f97-c1-2-6-&dm_sid=1442463131280313184a128030188f97&loginfo=74559208|68a0f6a3d862|4|68a0f6a3d862|000000000000000|68a0f6a3d862&client_style=1&animeversion=h",
//                    "page": 1,
//                    "single_filesize": "182834781",
//                    "width": null,
//                    "height": null
//            }
//            ],
//            "provision": "W704",
//                "filesize": 182834781,
//                "serial_title": "小羊肖恩"
//        }
//
//
//        ------------------------------------------------------------------------------------------------------------------------------------
//
//
//                ------------------------------------------------------------------------------------------------------------------------------
//
//
//                ------------------------------------------------------------------------------------------------------------------------------------
//    }
 /*************播放页面的 api 结束**********/



 /****************首页 api  开始*************/
    //首页顶部轮播图
    //public static final String  home_top_viewpager=http://api.icartoons.cn/v4/contents/position.json?posid=2&sig=QUlxzaFec5I4u1Dw0sWjc2UwQxQYLeeoQKPMkP3%2FnlxVWAgMX2UjBLgAuzKzcWtNb26vIZMs2gh7kZo0qWG2GDZ2vpDfg4qSMmEe3LZyf%2B9dxtcM1rQPEKcVqefwH1KE3BypMwVh8hjaJT1oRXlplp1Je5eV6X%2Bemc82P22oeN4%3D

//	{
//	    "record_count": 10,
//	    "items": [
//	        {
//	            "data_type": 1,
//	            "title": "创圣的大天使LOGOS",
//	            "sub_title": "每周五00:30更新",
//	            "cover": "http://img0.icartoons.cn/opftp/c4x_pic/c4x_position/201509/20150911005111413924.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&loginfo=74559224|2947916703|6|68a0f6a3d862|000000000000000|68a0f6a3d862",
//	            "click_action": "2",
//	            "url": "",
//	            "trackid": "144193462087532696eb757e02b6f42a-c1-2-1-",
//	            "serial_id": "2S201509012200092907",
//	            "serial_status": 0,
//	            "update_set": "11",
//	            "desc": "过去，曾有过人类的声音唤醒万物真理的时代。但，经由某种发明，人类的历史迎来巨大的转换期。“文字”——它作为优越的传达手段在瞬间普及，并令声音与真理之间的“LOGOS世界”诞生了。",
//	            "pic": "http://img0.icartoons.cn/spftp/temp/2015090602091300000096712542/720x405.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&loginfo=74559224|2947916703|6|68a0f6a3d862|000000000000000|68a0f6a3d862"
//	        },
//	        {
//	            "data_type": 1,
//	            "title": "推理神剧：乱步奇谭",
//	            "sub_title": "每周五1:30更新",
//	            "cover": "http://img0.icartoons.cn/opftp/c4x_pic/c4x_position/201509/20150911003611618266.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&loginfo=74559224|2947916703|6|68a0f6a3d862|000000000000000|68a0f6a3d862",
//	            "click_action": "2",
//	            "url": "",
//	            "trackid": "144193462087532696eb757e02b6f42a-c1-2-2-",
//	            "serial_id": "2S201507032200092706",
//	            "serial_status": 0,
//	            "update_set": "10",
//	            "desc": "【爱动漫日漫新番同步首发】原案来自日本推理小说之父江户川乱步，。故事讲述的是在某所中学发生了教师遇害事件，就读于这所学校的少年小林，与前来搜查事件的天才侦探明智相遇。小林不顾朋友羽柴的担心，自愿成为明智的“助手”，全情投入到接连发生的奇怪事",
//	            "pic": "http://img0.icartoons.cn/spftp/temp/2015072809402600000079813943/720x405.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&loginfo=74559224|2947916703|6|68a0f6a3d862|000000000000000|68a0f6a3d862"
//	        },
//	        {
//	            "data_type": 1,
//	            "title": "机甲动画",
//	            "sub_title": "",
//	            "cover": "http://img0.icartoons.cn/opftp/c4x_pic/position/201509/20150909171727866917.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&loginfo=74559224|2947916703|6|68a0f6a3d862|000000000000000|68a0f6a3d862",
//	            "click_action": "12",
//	            "url": "",
//	            "trackid": "144193462087532696eb757e02b6f42a-c1-2-3-",
//	            "serial_id": "64"
//	        },
//	        {
//	            "data_type": 1,
//	            "title": "小羊肖恩",
//	            "sub_title": "大眼睛萌羊奔向大荧幕",
//	            "cover": "http://img0.icartoons.cn/opftp/c4x_pic/position/201509/20150907102322507065.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&loginfo=74559224|2947916703|6|68a0f6a3d862|000000000000000|68a0f6a3d862",
//	            "click_action": "2",
//	            "url": "",
//	            "trackid": "144193462087532696eb757e02b6f42a-c1-2-4-",
//	            "serial_id": "2S201509042200092911",
//	            "serial_status": "1",
//	            "update_set": "1",
//	            "desc": "小羊肖恩厌倦了日复一日接受农夫指令的生活，计划和羊群放假一天。可原本的计划发生了意外，旧篷车把熟睡的农夫送进了大城市。农场的生活变得混乱不堪，肖恩开始懊恼，最终决定和羊群进入大城市，找回主人。",
//	            "pic": "http://img0.icartoons.cn/opftp/20150906/129525/201509042200092911/cover/720x405.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&loginfo=74559224|2947916703|6|68a0f6a3d862|000000000000000|68a0f6a3d862"
//	        },
//	        {
//	            "data_type": 1,
//	            "title": "六花的勇者",
//	            "sub_title": "每周日3:30更新",
//	            "cover": "http://img0.icartoons.cn/opftp/c4x_pic/c4x_position/201509/20150905224214577974.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&loginfo=74559224|2947916703|6|68a0f6a3d862|000000000000000|68a0f6a3d862",
//	            "click_action": "2",
//	            "url": "",
//	            "trackid": "144193462087532696eb757e02b6f42a-c1-2-5-",
//	            "serial_id": "2S201507052200092708",
//	            "serial_status": 0,
//	            "update_set": "10",
//	            "desc": "【爱动漫日漫新番同步首发】传说，当魔物从黑暗深渊觉醒，世间化为地狱之时，命运之神会选出六位勇者并将授予此六人拯救世界之力。现在开始所要讲述的，便是背负着拯救世界使命的勇者们的故事。",
//	            "pic": "http://img0.icartoons.cn/spftp/temp/2015070610364100000062612542/720x405.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&loginfo=74559224|2947916703|6|68a0f6a3d862|000000000000000|68a0f6a3d862"
//	        },
//	        {
//	            "data_type": 1,
//	            "title": "偶像大师灰姑娘女孩2",
//	            "sub_title": "每周六18点更新",
//	            "cover": "http://img0.icartoons.cn/opftp/c4x_pic/c4x_position/201509/20150908174539254354.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&loginfo=74559224|2947916703|6|68a0f6a3d862|000000000000000|68a0f6a3d862",
//	            "click_action": "2",
//	            "url": "",
//	            "trackid": "144193462087532696eb757e02b6f42a-c1-2-6-",
//	            "serial_id": "2S201507172200092782",
//	            "serial_status": 0,
//	            "update_set": "8",
//	            "desc": "老牌艺人事务所“346Production”旗下拥有众多偶像艺人。如今事务所推出了全新组合“CINDERELLA PROJECT（灰姑娘计划）”，被选中的少女们从此走上了偶像演艺之路。",
//	            "pic": "http://img0.icartoons.cn/opftp/20150718/7504/201507172200092782/cover/720x405.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&loginfo=74559224|2947916703|6|68a0f6a3d862|000000000000000|68a0f6a3d862"
//	        },
//	        {
//	            "data_type": 1,
//	            "title": "爸爸去哪儿3",
//	            "sub_title": "每周六12点更新",
//	            "cover": "http://img0.icartoons.cn/opftp/c4x_pic/c4x_position/201508/20150829074618187495.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&loginfo=74559224|2947916703|6|68a0f6a3d862|000000000000000|68a0f6a3d862",
//	            "click_action": "2",
//	            "url": "",
//	            "trackid": "144193462087532696eb757e02b6f42a-c1-2-7-",
//	            "serial_id": "2S201507112200092743",
//	            "serial_status": 0,
//	            "update_set": "8",
//	            "desc": "《爸爸去哪儿》第三季是湖南卫视2015年度第三季\r\n度推出的亲子户外真人秀节目。该节目由李锐担任主\r\n持，嘉宾由刘烨父子、邹市明父子、胡军父子、林永\r\n健父子、夏克立父女共五对明星爸爸及子女参加 。",
//	            "pic": "http://img0.icartoons.cn/opftp/20150711/129803/201507112200092743/cover/720x405.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&loginfo=74559224|2947916703|6|68a0f6a3d862|000000000000000|68a0f6a3d862"
//	        },
//	        {
//	            "data_type": 1,
//	            "title": "馒头君送钱钱",
//	            "sub_title": "",
//	            "cover": "http://img0.icartoons.cn/opftp/c4x_pic/position/201507/20150731152634622741.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&loginfo=74559224|2947916703|6|68a0f6a3d862|000000000000000|68a0f6a3d862",
//	            "click_action": "4",
//	            "url": "http://www.icartoons.cn/index.php?m=activity&c=money&a=welcome&share_contents=送小钱钱啦http://www.icartoons.cn/t/84d3c9e5&client_version=4.0.11&userid=74559224",
//	            "trackid": "144193462087532696eb757e02b6f42a-c1-2-8-"
//	        },
//	        {
//	            "data_type": 1,
//	            "title": "爸爸去哪儿大合集",
//	            "sub_title": "",
//	            "cover": "http://img0.icartoons.cn/opftp/c4x_pic/position/201507/20150728204056146441.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&loginfo=74559224|2947916703|6|68a0f6a3d862|000000000000000|68a0f6a3d862",
//	            "click_action": "12",
//	            "url": "",
//	            "trackid": "144193462087532696eb757e02b6f42a-c1-2-9-",
//	            "serial_id": "3"
//	        },
//	        {
//	            "data_type": 1,
//	            "title": "藏文化",
//	            "sub_title": "",
//	            "cover": "http://img0.icartoons.cn/opftp/c4x_pic/position/201508/20150813171546925499.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&loginfo=74559224|2947916703|6|68a0f6a3d862|000000000000000|68a0f6a3d862",
//	            "click_action": "12",
//	            "url": "",
//	            "trackid": "144193462087532696eb757e02b6f42a-c1-2-10-",
//	            "serial_id": "40"
//	        }
//	    ]
//	}

    // 频道 分类
    //http://api.icartoons.cn/v4/column/channels.json?type=1&sig=ijEPz8hUDlWPlsTeydjOjO8UXx6gJubAtU8oLfwSwXne4P6kA4KC8wOb99ElrS9f%2FqfMdvljshqYacIUx%2FyK3b4UyqDi1ZVmMBUSvAv8gCiAbA%2FAiRmhrfSTsyT94GEp59bhuM3LtNjaFXuRjwDcM7PE4ycLmOrcDyu%2Fs2hI60M%3D
//	{
//	    "record_num": 2,
//	    "channel_desc": [
//	        {
//	            "channel_name": "动画频道",
//	            "sub_channel_num": 6,
//	            "parent_ch_id": 1,
//	            "items": [
//	                {
//	                    "sub_channel_id": "89",
//	                    "sub_channel_name": "热血",
//	                    "cover": "http://img0.icartoons.cn/opftp/c4x_pic/column/201507/20150730090458846331.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&loginfo=74559224|2947916703|6|68a0f6a3d862|000000000000000|68a0f6a3d862",
//	                    "channel_type": 1,
//	                    "channel_tag": ""
//	                },
//	                {
//	                    "sub_channel_id": "86",
//	                    "sub_channel_name": "日韩",
//	                    "cover": "http://img0.icartoons.cn/opftp/c4x_pic/column/201508/20150812141958620606.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&loginfo=74559224|2947916703|6|68a0f6a3d862|000000000000000|68a0f6a3d862",
//	                    "channel_type": 1,
//	                    "channel_tag": ""
//	                },
//	                {
//	                    "sub_channel_id": "81",
//	                    "sub_channel_name": "电影",
//	                    "cover": "http://img0.icartoons.cn/opftp/c4x_pic/column/201508/20150812144937668626.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&loginfo=74559224|2947916703|6|68a0f6a3d862|000000000000000|68a0f6a3d862",
//	                    "channel_type": 1,
//	                    "channel_tag": ""
//	                },
//	                {
//	                    "sub_channel_id": "79",
//	                    "sub_channel_name": "玄幻",
//	                    "cover": "http://img0.icartoons.cn/opftp/c4x_pic/column/201508/20150812145947688219.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&loginfo=74559224|2947916703|6|68a0f6a3d862|000000000000000|68a0f6a3d862",
//	                    "channel_type": 1,
//	                    "channel_tag": ""
//	                },
//	                {
//	                    "sub_channel_id": "74",
//	                    "sub_channel_name": "爆笑",
//	                    "cover": "http://img0.icartoons.cn/opftp/c4x_pic/column/201507/20150728205219318789.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&loginfo=74559224|2947916703|6|68a0f6a3d862|000000000000000|68a0f6a3d862",
//	                    "channel_type": 1,
//	                    "channel_tag": ""
//	                },
//	                {
//	                    "sub_channel_id": "72",
//	                    "sub_channel_name": "欧美",
//	                    "cover": "http://img0.icartoons.cn/opftp/c4x_pic/column/201508/20150812150335308633.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&loginfo=74559224|2947916703|6|68a0f6a3d862|000000000000000|68a0f6a3d862",
//	                    "channel_type": 1,
//	                    "channel_tag": ""
//	                }
//	            ]
//	        },
//	        {
//	            "channel_name": "热门专辑",
//	            "sub_channel_num": 4,
//	            "parent_ch_id": 2,
//	            "items": [
//	                {
//	                    "sub_channel_name": "西游记专题",
//	                    "cover": "http://img0.icartoons.cn/opftp/c4x_pic/special/201507/20150717161150544772.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&loginfo=74559224|2947916703|6|68a0f6a3d862|000000000000000|68a0f6a3d862",
//	                    "sub_channel_id": "50",
//	                    "channel_type": 2,
//	                    "channel_tag": ""
//	                },
//	                {
//	                    "sub_channel_name": "精选专题",
//	                    "cover": "http://img0.icartoons.cn/opftp/c4x_pic/special/201507/20150710142954961456.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&loginfo=74559224|2947916703|6|68a0f6a3d862|000000000000000|68a0f6a3d862",
//	                    "sub_channel_id": "49",
//	                    "channel_type": 2,
//	                    "channel_tag": ""
//	                },
//	                {
//	                    "sub_channel_name": "藏文化",
//	                    "cover": "http://img0.icartoons.cn/opftp/c4x_pic/special/201507/20150730143421113611.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&loginfo=74559224|2947916703|6|68a0f6a3d862|000000000000000|68a0f6a3d862",
//	                    "sub_channel_id": "40",
//	                    "channel_type": 2,
//	                    "channel_tag": ""
//	                },
//	                {
//	                    "sub_channel_name": "机甲动画",
//	                    "cover": "http://img0.icartoons.cn/opftp/c4x_pic/special/201509/20150909171308913453.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&loginfo=74559224|2947916703|6|68a0f6a3d862|000000000000000|68a0f6a3d862",
//	                    "sub_channel_id": "64",
//	                    "channel_type": 2,
//	                    "channel_tag": ""
//	                }
//	            ]
//	        }
//	    ]
//	}

    // 首页推荐位置6个 动画
    //http://api.icartoons.cn/v4/contents/position.json?posid=4&sig=zdrMT6MixLboTnSmQkhxxCLlDRhwawXspuThHWpfqNHK9HGG0iq%2BnImW%2FhPOD2T7mbWJmPKiPQFKaXadthLbAxzgHbWMboH5FElJReqWMs1GtLAwWttAw8hL8Pf%2FFeaUWQ8FQZphvIBm8%2FORd5lC0G1Wj00NOsFGxMCIBX%2FH6%2Bw%3D
//	{
//	    "record_count": 6,
//	    "items": [
//	        {
//	            "data_type": 2,
//	            "title": "六花的勇者",
//	            "sub_title": "每周日3:30更新",
//	            "cover": "http://img0.icartoons.cn/opftp/c4x_pic/c4x_position/201508/20150823003414888155.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&loginfo=74559224|2947916703|6|68a0f6a3d862|000000000000000|68a0f6a3d862",
//	            "click_action": "2",
//	            "url": "",
//	            "trackid": "144193462087532696eb757e02b6f42a-c1-4-1-",
//	            "serial_id": "2S201507052200092708",
//	            "serial_status": 0,
//	            "update_set": "10",
//	            "w_type": 0,
//	            "superscript": "",
//	            "desc": "【爱动漫日漫新番同步首发】传说，当魔物从黑暗深渊觉醒，世间化为地狱之时，命运之神会选出六位勇者并将授予此六人拯救世界之力。现在开始所要讲述的，便是背负着拯救世界使命的勇者们的故事。",
//	            "pic": "http://img0.icartoons.cn/spftp/temp/2015070610364100000062612542/720x405.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&loginfo=74559224|2947916703|6|68a0f6a3d862|000000000000000|68a0f6a3d862"
//	        },
//	        {
//	            "data_type": 2,
//	            "title": "光明之泪×风",
//	            "sub_title": "梦幻大陆上的妖精",
//	            "cover": "http://img0.icartoons.cn/opftp/c4x_pic/position/201507/20150710160203521569.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&loginfo=74559224|2947916703|6|68a0f6a3d862|000000000000000|68a0f6a3d862",
//	            "click_action": "2",
//	            "url": "",
//	            "trackid": "144193462087532696eb757e02b6f42a-c1-4-2-",
//	            "serial_id": "2S201507072200092718",
//	            "serial_status": "1",
//	            "update_set": "13",
//	            "w_type": 0,
//	            "superscript": "",
//	            "desc": "不可思议的风翻转着书页，本不该开花地古樱花树肆意绽放，于是打开了通向异世界的大门——秋月苍真为寻找失踪的好朋友而来到了一个住着兽人、怪兽的奇幻世界。",
//	            "pic": "http://img0.icartoons.cn/spftp/temp/2015071404433000000016212542/720x405.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&loginfo=74559224|2947916703|6|68a0f6a3d862|000000000000000|68a0f6a3d862"
//	        },
//	        {
//	            "data_type": 2,
//	            "title": "蜡笔小新 第二季",
//	            "sub_title": "萌娃的爆笑生活",
//	            "cover": "http://img0.icartoons.cn/opftp/c4x_pic/position/201509/20150911091510396532.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&loginfo=74559224|2947916703|6|68a0f6a3d862|000000000000000|68a0f6a3d862",
//	            "click_action": "2",
//	            "url": "",
//	            "trackid": "144193462087532696eb757e02b6f42a-c1-4-3-",
//	            "serial_id": "2S201507072200092720",
//	            "serial_status": 0,
//	            "update_set": "630",
//	            "w_type": 0,
//	            "superscript": "",
//	            "desc": "小新是一个年仅5岁，正在幼儿园上学的小男孩。他家住在春日市的市郊，家里有爸爸妈妈，还有一条小狗。作者臼井仪人从日常生活中的故事取材，叙述小新在日常生活中所发生的事情。小新是一个有点调皮的小孩，他喜欢别出心裁，富于幻想。",
//	            "pic": "http://img0.icartoons.cn/spftp/temp/2015072709355000000082412542/720x405.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&loginfo=74559224|2947916703|6|68a0f6a3d862|000000000000000|68a0f6a3d862"
//	        },
//	        {
//	            "data_type": 2,
//	            "title": "圣母在上 第二季",
//	            "sub_title": "少女们的友谊",
//	            "cover": "http://img0.icartoons.cn/opftp/c4x_pic/c4x_position/201509/20150906030001736575.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&loginfo=74559224|2947916703|6|68a0f6a3d862|000000000000000|68a0f6a3d862",
//	            "click_action": "2",
//	            "url": "",
//	            "trackid": "144193462087532696eb757e02b6f42a-c1-4-4-",
//	            "serial_id": "2S201507082200092734",
//	            "serial_status": "1",
//	            "update_set": "13",
//	            "w_type": 0,
//	            "superscript": "",
//	            "desc": "某天清晨，学园的普通一年级生福泽祐巳在向圣母玛利亚的雕像祷告时，被人从后面叫住了。而声音的主人就是红蔷薇的花蕾，莉莉安女学园的明星，小笠原祥子……",
//	            "pic": "http://img0.icartoons.cn/spftp/temp/2015081110065800000088512542/720x405.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&loginfo=74559224|2947916703|6|68a0f6a3d862|000000000000000|68a0f6a3d862"
//	        },
//	        {
//	            "data_type": 2,
//	            "title": "新网球王子OVA2",
//	            "sub_title": "网球男神传奇再续",
//	            "cover": "http://img0.icartoons.cn/opftp/c4x_pic/position/201509/20150910100742813722.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&loginfo=74559224|2947916703|6|68a0f6a3d862|000000000000000|68a0f6a3d862",
//	            "click_action": "2",
//	            "url": "",
//	            "trackid": "144193462087532696eb757e02b6f42a-c1-4-5-",
//	            "serial_id": "2S201507212200092803",
//	            "serial_status": 0,
//	            "update_set": "10",
//	            "w_type": 0,
//	            "superscript": "",
//	            "desc": "从美国回来的龙马接受了更加严苛的训练，他们终于将要进军世界了。在体育竞技方面，从全国大赛时便开始愈发的脱离常识。在全国大赛奋勇激战的中学生们选取了50名精英作为代表，这次将要向高中生挑战。这次故事的舞台是U-17，日本代表集训。",
//	            "pic": "http://img0.icartoons.cn/opftp/20150724/7504/201507212200092803/cover/720x405.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&loginfo=74559224|2947916703|6|68a0f6a3d862|000000000000000|68a0f6a3d862"
//	        },
//	        {
//	            "data_type": 2,
//	            "title": "小羊肖恩",
//	            "sub_title": "大眼萌羊来袭",
//	            "cover": "http://img0.icartoons.cn/opftp/c4x_pic/position/201509/20150907142715557553.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&loginfo=74559224|2947916703|6|68a0f6a3d862|000000000000000|68a0f6a3d862",
//	            "click_action": "2",
//	            "url": "",
//	            "trackid": "144193462087532696eb757e02b6f42a-c1-4-6-",
//	            "serial_id": "2S201509042200092911",
//	            "serial_status": "1",
//	            "update_set": "1",
//	            "w_type": 0,
//	            "superscript": "",
//	            "desc": "小羊肖恩厌倦了日复一日接受农夫指令的生活，计划和羊群放假一天。可原本的计划发生了意外，旧篷车把熟睡的农夫送进了大城市。农场的生活变得混乱不堪，肖恩开始懊恼，最终决定和羊群进入大城市，找回主人。",
//	            "pic": "http://img0.icartoons.cn/opftp/20150906/129525/201509042200092911/cover/720x405.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&loginfo=74559224|2947916703|6|68a0f6a3d862|000000000000000|68a0f6a3d862"
//	        }
//	    ]
//	}


    // 首页 日韩 爆笑  等等
//    http://api.icartoons.cn/v4/contents/show_area.json?type=1&sig=d1MRdM3pqP5bScvS7P21hva77k3EbZWlEVUbqSUPjhX2NiMw4Quv5afyFSgZE1ndul6ODR0ZBwEQAM1yThc0gGthniD%2Bi%2F%2FSAA4Yjs4GyS1ghb5lDaqbasjF4Z%2BcpYH1lag8%2FIzbIrKIcAqOOS9%2BaYLq67dIyF0gh%2BqXm7JtiwU%3D
//	{
//	    "record_count": 4,
//	    "items": [
//	        {
//	            "data_cover": "http://img0.icartoons.cn/opftp/c4x_pic/position/201507/20150728161949147572.png?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&loginfo=74559224|2947916703|6|68a0f6a3d862|000000000000000|68a0f6a3d862",
//	            "data_id": "86",
//	            "data_name": "日韩",
//	            "data_type": 0,
//	            "contents": [
//	                {
//	                    "pic": "http://img0.icartoons.cn/opftp/20150718/7504/201507172200092782/cover/720x405.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&loginfo=74559224|2947916703|6|68a0f6a3d862|000000000000000|68a0f6a3d862",
//	                    "cover": "http://img0.icartoons.cn/opftp/c4x_pic/position/201508/20150812114009332619.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&loginfo=74559224|2947916703|6|68a0f6a3d862|000000000000000|68a0f6a3d862",
//	                    "serial_id": "2S201507172200092782",
//	                    "serial_status": 0,
//	                    "serial_type": 1,
//	                    "title": "偶像大师灰姑娘女孩2",
//	                    "sub_title": "每周六12:00更新",
//	                    "desc": "老牌艺人事务所“346Production”旗下拥有众多偶像艺人。如今事务所推出了全新组合“CINDERELLA PROJECT（灰姑娘计划）”，被选中的少女们从此走上了偶像演艺之路。",
//	                    "update_set": "8",
//	                    "w_type": 0,
//	                    "superscript": "",
//	                    "trackid": "144193462087532696eb757e02b6f42a-c15-365-1-"
//	                },
//	                {
//	                    "pic": "http://img0.icartoons.cn/opftp/20140709/129803/201407032200090718/cover/720x405.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&loginfo=74559224|2947916703|6|68a0f6a3d862|000000000000000|68a0f6a3d862",
//	                    "cover": "http://img0.icartoons.cn/opftp/c4x_pic/position/201507/20150729144728653014.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&loginfo=74559224|2947916703|6|68a0f6a3d862|000000000000000|68a0f6a3d862",
//	                    "serial_id": "2S201407032200090718",
//	                    "serial_status": 0,
//	                    "serial_type": 1,
//	                    "title": "网球优等生",
//	                    "sub_title": "正太与萌妹的情史",
//	                    "desc": "故事的主人翁─尾崎荣一郎，是个功课一直都拿优等的高中一年级生。原本他的生活只是努力用功念书，但为了解决运动不足的问题，他开始打算尝试运动，而就在他妈妈帮他找到一家网球俱乐部并逼他去看看后，他的人生开始起了大变化。",
//	                    "update_set": "25",
//	                    "w_type": 0,
//	                    "superscript": "",
//	                    "trackid": "144193462087532696eb757e02b6f42a-c15-365-2-"
//	                },
//	                {
//	                    "pic": "http://img0.icartoons.cn/spftp/temp/2015051311445500000015112542/720x405.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&loginfo=74559224|2947916703|6|68a0f6a3d862|000000000000000|68a0f6a3d862",
//	                    "cover": "http://img0.icartoons.cn/opftp/c4x_pic/c4x_position/201507/20150728181706734660.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&loginfo=74559224|2947916703|6|68a0f6a3d862|000000000000000|68a0f6a3d862",
//	                    "serial_id": "2S201502052200091899",
//	                    "serial_status": "1",
//	                    "serial_type": 1,
//	                    "title": "传说中勇者的传说",
//	                    "sub_title": "英雄不问出处",
//	                    "desc": "故事讲述了在一个架空的魔幻世界中，各地都藏有与勇者有关的传说，为了集齐这些遗物，主角“莱纳”与女主角“菲利斯”一同展开旅行的一个壮阔的冒险剧故事。",
//	                    "update_set": "24",
//	                    "w_type": 0,
//	                    "superscript": "",
//	                    "trackid": "144193462087532696eb757e02b6f42a-c15-365-3-"
//	                },
//	                {
//	                    "pic": "http://img0.icartoons.cn/spftp/temp/2015060411043200000063412542/720x405.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&loginfo=74559224|2947916703|6|68a0f6a3d862|000000000000000|68a0f6a3d862",
//	                    "cover": "http://img0.icartoons.cn/opftp/c4x_pic/position/201508/20150812114705496359.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&loginfo=74559224|2947916703|6|68a0f6a3d862|000000000000000|68a0f6a3d862",
//	                    "serial_id": "2S201502122200091962",
//	                    "serial_status": "1",
//	                    "serial_type": 1,
//	                    "title": "来自新世界",
//	                    "sub_title": "1000年后的世界",
//	                    "desc": "1000年后的世界，日本的孩子们正不断地消失，只存在想象中的恐怖动物与人类展开殊死战斗。",
//	                    "update_set": "25",
//	                    "w_type": 0,
//	                    "superscript": "",
//	                    "trackid": "144193462087532696eb757e02b6f42a-c15-365-4-"
//	                },
//	                {
//	                    "pic": "http://img0.icartoons.cn/opftp/20150326/129542/201503242200092252/cover/720x405.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&loginfo=74559224|2947916703|6|68a0f6a3d862|000000000000000|68a0f6a3d862",
//	                    "cover": "http://img0.icartoons.cn/opftp/c4x_pic/position/201508/20150812114444314639.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&loginfo=74559224|2947916703|6|68a0f6a3d862|000000000000000|68a0f6a3d862",
//	                    "serial_id": "2S201503242200092252",
//	                    "serial_status": "1",
//	                    "serial_type": 1,
//	                    "title": "毁灭世界的六人",
//	                    "sub_title": "世界真奇妙",
//	                    "desc": "一个被「沙海」的黄沙的海洋所包围的世界--- 四季分立的大陆漂浮于其上，在那里，被称为兽人的种族支配着人类。",
//	                    "update_set": "13",
//	                    "w_type": 0,
//	                    "superscript": "",
//	                    "trackid": "144193462087532696eb757e02b6f42a-c15-365-5-"
//	                }
//	            ]
//	        },
//	        {
//	            "data_cover": "http://img0.icartoons.cn/opftp/c4x_pic/position/201507/20150728160747478694.png?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&loginfo=74559224|2947916703|6|68a0f6a3d862|000000000000000|68a0f6a3d862",
//	            "data_id": "81",
//	            "data_name": "电影",
//	            "data_type": 0,
//	            "contents": [
//	                {
//	                    "pic": "http://img0.icartoons.cn/spftp/temp/2015050603104000000039513740/720x405.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&loginfo=74559224|2947916703|6|68a0f6a3d862|000000000000000|68a0f6a3d862",
//	                    "cover": "http://img0.icartoons.cn/opftp/c4x_pic/position/201507/20150730171655165621.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&loginfo=74559224|2947916703|6|68a0f6a3d862|000000000000000|68a0f6a3d862",
//	                    "serial_id": "2S201407012200090703",
//	                    "serial_status": "1",
//	                    "serial_type": 1,
//	                    "title": "爸爸去哪儿大电影",
//	                    "sub_title": "明星亲子旅行生存体验",
//	                    "desc": "一部父子亲情真人秀《爸爸去哪儿》，在中国掀起收视狂潮和广泛热议。明星爸爸们的舐犊情深，和萌娃们天真可爱的俏皮模样，给观众留下了深刻的印象。",
//	                    "update_set": "4",
//	                    "w_type": 0,
//	                    "superscript": "",
//	                    "trackid": "144193462087532696eb757e02b6f42a-c15-359-1-"
//	                },
//	                {
//	                    "pic": "http://img0.icartoons.cn/opftp/20140930/129805/201407312200090917/cover/720x405.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&loginfo=74559224|2947916703|6|68a0f6a3d862|000000000000000|68a0f6a3d862",
//	                    "cover": "http://img0.icartoons.cn/opftp/c4x_pic/position/201507/20150730171544807341.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&loginfo=74559224|2947916703|6|68a0f6a3d862|000000000000000|68a0f6a3d862",
//	                    "serial_id": "2S201407312200090917",
//	                    "serial_status": "1",
//	                    "serial_type": 1,
//	                    "title": "天才眼镜狗",
//	                    "sub_title": "眼镜狗和眼镜男孩",
//	                    "desc": "为了让养子能更好的见证世界的奇妙，他自己发明了一台时光穿梭机。皮博迪与谢尔曼一起穿越时空，四处冒险，并闹出各种笑话。",
//	                    "update_set": "3",
//	                    "w_type": 0,
//	                    "superscript": "",
//	                    "trackid": "144193462087532696eb757e02b6f42a-c15-359-2-"
//	                },
//	                {
//	                    "pic": "http://img0.icartoons.cn/spftp/temp/2015032403104900000037011062/720x405.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&loginfo=74559224|2947916703|6|68a0f6a3d862|000000000000000|68a0f6a3d862",
//	                    "cover": "http://img0.icartoons.cn/opftp/c4x_pic/position/201509/20150906112309818110.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&loginfo=74559224|2947916703|6|68a0f6a3d862|000000000000000|68a0f6a3d862",
//	                    "serial_id": "2S201410082200091166",
//	                    "serial_status": "1",
//	                    "serial_type": 1,
//	                    "title": "丛林之王",
//	                    "sub_title": "人猿泰山100周年",
//	                    "desc": "纽约企业家约翰·格雷斯托克带着家人深入非洲丛林腹地，不料直升机坠毁，他和妻子不幸遇难。死里逃生的“小泰山”被猩猩卡拉所救并被抚养长大。10年的丛林生活，泰山练就了超强的生存技能，却丧失了人类的基本情感，直到珍妮的出现改变了他，但珍妮的同伴为了利益要毁灭丛林，泰山带领猩族奋起反击，利用自己的丛林技能和智慧，捍卫丛林法则，保卫他的家园和他所爱的人。",
//	                    "update_set": "3",
//	                    "w_type": 0,
//	                    "superscript": "",
//	                    "trackid": "144193462087532696eb757e02b6f42a-c15-359-3-"
//	                },
//	                {
//	                    "pic": "http://img0.icartoons.cn/opftp/20141105/129525/201411032200091282/cover/720x405.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&loginfo=74559224|2947916703|6|68a0f6a3d862|000000000000000|68a0f6a3d862",
//	                    "cover": "http://img0.icartoons.cn/opftp/c4x_pic/position/201507/20150729151823734249.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&loginfo=74559224|2947916703|6|68a0f6a3d862|000000000000000|68a0f6a3d862",
//	                    "serial_id": "2S201411032200091282",
//	                    "serial_status": "1",
//	                    "serial_type": 1,
//	                    "title": "麦兜我和我妈妈",
//	                    "sub_title": "可爱猪仔爱搞怪",
//	                    "desc": "神探波比被誉为自福尔摩斯以来最深入民心的私家侦探,美国FBI英国苏格兰场都邀请波比麦为特别顾问,神探波比说一切都得自我妈妈,直至那年他回想着妈妈为他所做的一切每点爱在麦兜脑子里碰碰撞撞,重新排列麦太的聪明忽然出现在麦兜身上。",
//	                    "update_set": "1",
//	                    "w_type": 0,
//	                    "superscript": "",
//	                    "trackid": "144193462087532696eb757e02b6f42a-c15-359-4-"
//	                },
//	                {
//	                    "pic": "http://img0.icartoons.cn/spftp/temp/2015070604245100000042111062/720x405.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&loginfo=74559224|2947916703|6|68a0f6a3d862|000000000000000|68a0f6a3d862",
//	                    "cover": "http://img0.icartoons.cn/opftp/c4x_pic/c4x_position/201507/20150730030010957393.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&loginfo=74559224|2947916703|6|68a0f6a3d862|000000000000000|68a0f6a3d862",
//	                    "serial_id": "2S201507012200092694",
//	                    "serial_status": "1",
//	                    "serial_type": 1,
//	                    "title": "哆啦A梦（伴我同行）",
//	                    "sub_title": "哆啦a梦要走了",
//	                    "desc": "生活在日本东京的野比大雄是一个饱受同学欺负的男孩。他的性格不仅左右着自己的事业和婚姻，还对未来子孙产生莫大的影响。为此，大雄孙子的孙子世修带着猫型机器人哆啦A梦乘坐时光机突然来访，期望彻底改变大雄及整个家族的命运。在哆啦A梦的帮助下，大雄穿越时空，见证了决定人生的最关键的时刻和事件。当大雄追求幸福之际，哆啦A梦也到了必须返回22世纪的时候……",
//	                    "update_set": "1",
//	                    "w_type": 0,
//	                    "superscript": "",
//	                    "trackid": "144193462087532696eb757e02b6f42a-c15-359-5-"
//	                }
//	            ]
//	        },
//	        {
//	            "data_cover": "http://img0.icartoons.cn/opftp/c4x_pic/position/201507/20150728162152530973.png?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&loginfo=74559224|2947916703|6|68a0f6a3d862|000000000000000|68a0f6a3d862",
//	            "data_id": "74",
//	            "data_name": "爆笑",
//	            "data_type": 0,
//	            "contents": [
//	                {
//	                    "pic": "http://img0.icartoons.cn/spftp/temp/2015081110250300000047912542/720x405.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&loginfo=74559224|2947916703|6|68a0f6a3d862|000000000000000|68a0f6a3d862",
//	                    "cover": "http://img0.icartoons.cn/opftp/c4x_pic/c4x_position/201507/20150728181643991300.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&loginfo=74559224|2947916703|6|68a0f6a3d862|000000000000000|68a0f6a3d862",
//	                    "serial_id": "2S201506152200092651",
//	                    "serial_status": "1",
//	                    "serial_type": 1,
//	                    "title": "城市猎人特别版",
//	                    "sub_title": "都市传说猎人",
//	                    "desc": "该作品以生动幽默的风格描述一位好色、身怀绝技而又有自身缺点、令人可爱又可恨，自称城市清道夫的冴羽獠（大陆曾译作：寒羽良）与他的同伴槙村香所组合的私家侦探事务所的故事。",
//	                    "update_set": "27",
//	                    "w_type": 0,
//	                    "superscript": "",
//	                    "trackid": "144193462087532696eb757e02b6f42a-c15-351-1-"
//	                },
//	                {
//	                    "pic": "http://img0.icartoons.cn/spftp/temp/2015052509192600000057210336/720x405.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&loginfo=74559224|2947916703|6|68a0f6a3d862|000000000000000|68a0f6a3d862",
//	                    "cover": "http://img0.icartoons.cn/opftp/c4x_pic/position/201508/20150804152814972393.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&loginfo=74559224|2947916703|6|68a0f6a3d862|000000000000000|68a0f6a3d862",
//	                    "serial_id": "2S0037081215",
//	                    "serial_status": "1",
//	                    "serial_type": 1,
//	                    "title": "猫和老鼠",
//	                    "sub_title": "亦敌亦友",
//	                    "desc": "汤姆和杰瑞是天生的宿敌。这对相爱相杀的好基友，总是闹出一些超乎想象的恶作剧，让你啼笑皆非。",
//	                    "update_set": "111",
//	                    "w_type": 0,
//	                    "superscript": "",
//	                    "trackid": "144193462087532696eb757e02b6f42a-c15-351-2-"
//	                },
//	                {
//	                    "pic": "http://img0.icartoons.cn/opftp/20131119/5204/201311192200088772/cover/720x405.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&loginfo=74559224|2947916703|6|68a0f6a3d862|000000000000000|68a0f6a3d862",
//	                    "cover": "http://img0.icartoons.cn/opftp/c4x_pic/c4x_position/201507/20150728181642282303.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&loginfo=74559224|2947916703|6|68a0f6a3d862|000000000000000|68a0f6a3d862",
//	                    "serial_id": "2S201311192200088772",
//	                    "serial_status": 0,
//	                    "serial_type": 1,
//	                    "title": "流氓兔",
//	                    "sub_title": "韩国最火爆的兔子",
//	                    "desc": "风风靡全球的流氓兔来啦！他是一只慢条斯理、无厘头、喜欢恶作剧，多重性格、有被害妄想症的贱兔，他还可以从背后拿出许多道具，包括马桶，马桶刷，酒瓶等等……\r\n\r\n推荐语：无厘头流氓兔搞怪来袭，贱兔出没，各位小心喽……\r\n",
//	                    "update_set": "12",
//	                    "w_type": 0,
//	                    "superscript": "",
//	                    "trackid": "144193462087532696eb757e02b6f42a-c15-351-3-"
//	                },
//	                {
//	                    "pic": "http://img0.icartoons.cn/opftp/20140910/129803/201409032200091062/cover/720x405.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&loginfo=74559224|2947916703|6|68a0f6a3d862|000000000000000|68a0f6a3d862",
//	                    "cover": "http://img0.icartoons.cn/opftp/c4x_pic/position/201508/20150804152032654604.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&loginfo=74559224|2947916703|6|68a0f6a3d862|000000000000000|68a0f6a3d862",
//	                    "serial_id": "2S201409032200091062",
//	                    "serial_status": 0,
//	                    "serial_type": 1,
//	                    "title": "热带雨林的爆笑日记",
//	                    "sub_title": "哈雷小仔",
//	                    "desc": "《热带雨林的爆笑生活》是一部日本喜剧少年漫画。",
//	                    "update_set": "12",
//	                    "w_type": 0,
//	                    "superscript": "",
//	                    "trackid": "144193462087532696eb757e02b6f42a-c15-351-4-"
//	                },
//	                {
//	                    "pic": "http://img0.icartoons.cn/opftp/20141217/129803/201412162200091530/cover/720x405.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&loginfo=74559224|2947916703|6|68a0f6a3d862|000000000000000|68a0f6a3d862",
//	                    "cover": "http://img0.icartoons.cn/opftp/c4x_pic/c4x_position/201507/20150728181642139539.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&loginfo=74559224|2947916703|6|68a0f6a3d862|000000000000000|68a0f6a3d862",
//	                    "serial_id": "2S201412162200091530",
//	                    "serial_status": 0,
//	                    "serial_type": 1,
//	                    "title": "郭德纲相声小品系列",
//	                    "sub_title": "经典再现",
//	                    "desc": "该片将郭德纲以往的经典相声,以动画的形式重新包装呈现的动画作品。",
//	                    "update_set": "243",
//	                    "w_type": 0,
//	                    "superscript": "",
//	                    "trackid": "144193462087532696eb757e02b6f42a-c15-351-5-"
//	                }
//	            ]
//	        },
//	        {
//	            "data_cover": "http://img0.icartoons.cn/opftp/c4x_pic/position/201504/20150403175514418500.png?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&loginfo=74559224|2947916703|6|68a0f6a3d862|000000000000000|68a0f6a3d862",
//	            "click_action": "8",
//	            "data_id": 29,
//	            "data_name": "4399游戏盒",
//	            "data_type": 1,
//	            "data_url": "",
//	            "serial_id": "31",
//	            "set_id": "",
//	            "contents": null
//	        }
//	    ]
//	}

    // 首页底部的额应用推荐
    //http://api.icartoons.cn/v4/contents/position.json?posid=7&sig=CCRx9fiG6J2rT3rmNNi6cjSZPiuUSLpPtq9rtiwFvSGpuKSeWEvPZPCCysZIy6B1yEMGmS%2Bo%2B%2F0Ht7TKknLUy7C%2FQl1Dl0pWkJxvPW1EZY3VpiOpbmqR7dJxgUqLsoomMJ6zu2mXrS%2BXnqTATZl9AFV9PKHPqpqN5P1y2vgf5Bs%3D

//	{
//	    "record_count": 3,
//	    "items": [
//	        {
//	            "data_type": 3,
//	            "title": "4399游戏盒",
//	            "sub_title": "",
//	            "cover": "http://img0.icartoons.cn/opftp/c4x_pic/position/201503/20150310150145797536.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&loginfo=74559224|2947916703|6|68a0f6a3d862|000000000000000|68a0f6a3d862",
//	            "click_action": "8",
//	            "url": "",
//	            "trackid": "144193462087532696eb757e02b6f42a-c1-7-1-",
//	            "serial_id": "31"
//	        },
//	        {
//	            "data_type": 3,
//	            "title": "天翼视讯",
//	            "sub_title": "",
//	            "cover": "http://img0.icartoons.cn/opftp/c4x_pic/position/201409/20140910114230930913.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&loginfo=74559224|2947916703|6|68a0f6a3d862|000000000000000|68a0f6a3d862",
//	            "click_action": "8",
//	            "url": "",
//	            "trackid": "144193462087532696eb757e02b6f42a-c1-7-2-",
//	            "serial_id": "20"
//	        },
//	        {
//	            "data_type": 3,
//	            "title": "分期管家",
//	            "sub_title": "",
//	            "cover": "http://img0.icartoons.cn/opftp/c4x_pic/position/201509/20150902143624922630.png?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&loginfo=74559224|2947916703|6|68a0f6a3d862|000000000000000|68a0f6a3d862",
//	            "click_action": "8",
//	            "url": "",
//	            "trackid": "144193462087532696eb757e02b6f42a-c1-7-3-",
//	            "serial_id": "55"
//	        }
//	    ]
//	}


    //选中 一个 动漫 进入播放页面后  下面的 推荐位置
    //http://api.icartoons.cn/v4/contents/guessenjoy?content_id=2S201507052200092708&type=1&sig=jkHbE2FK5RIYKtaafgbdn9x6YMsmln%2BdA4JrwKv9Yu%2FpePmPGxiPsjggzqLcVpjEINK3%2BCvHeD58Yk8ZhRkYonB6j2%2B0uKD%2Fip3Pd%2FPfwIhfRZhPtyGBBEorpStcSu%2Bqy78OsGIewZeAqDYH9XNiJjN2y%2BcBeiBP5%2FNwfg3gHck%3D

    // 一个获取到的 动画要播放
    //http://api.icartoons.cn/v4/contents/resource?trackid=144193462087532696eb757e02b6f42a-c1-4-1-&serial_id=2S201507052200092708&content_id=2C201507053200190282&is_download=0&sig=BpXUvJkssu8TCgmkx8Ardn1S%2BreJhvR%2BT9PG0VwkXhZ%2BwfOB4oQIG0aIqCF4u5OFrJWgFp8jYZfOyqU6Nr19BFN8vm3aVjWspe7r9YjWJt7H%2BOPc5FKT2TIF1e8NT26bO5ahZx%2FxS%2Bxv58AxoBKpuCWTItuKiekegwxQSKQ2Jjs%3D
//	{
//	    "title": "六花的勇者 第1集",
//	    "totalcount": 1430,
//	    "baseurl": "",
//	    "items": [
//	        {
//	            "content_id": "2C201507053200190282",
//	            "set_num": "1",
//	            "url": "http://streaming-http.icartoons.cn:7388/cmstest/20150725/7504/201507053200190282/W1280.3gp?msisdn=74559224&spid=001&sid=005&appid=dm_zk_6001100_81&trackid=144193462087532696eb757e02b6f42a-c1-4-1-&dm_sid=144193462087532696eb757e02b6f42a&loginfo=74559224|2947916703|6|68a0f6a3d862|000000000000000|68a0f6a3d862&client_style=1&animeversion=j",
//	            "page": 1,
//	            "single_filesize": "141251350",
//	            "width": null,
//	            "height": null
//	        }
//	    ],
//	    "provision": "W1280",
//	    "filesize": 141251350,
//	    "serial_title": "六花的勇者",
//	    "next_chapter_id": "2C201507123200190855"
//	}


    //顶部轮播图 点击 爸爸去哪儿
    //http://api.icartoons.cn/v4/column/channel_list.json?channel_id=3&pagesize=12&parent_ch_id=2&page=0&sig=IMQeQrTek1Nh0DlufVxEm5SZFd2QDNGC8QGZoH8jFY6DHEgMdsYPfTgHXJilV4xyymhZSons2eBtwfWi4ib%2BAaQRXcShBNXBJcGkd8HyvS%2B1MnwnMRiwA5FjG%2BAqfy6fK%2B1ZIhLByjXhVNihrXUJESv67Zx9xZJbrtMxi6rcec0%3D
//	{
//	    "record_num": 6,
//	    "items": [
//	        {
//	            "serial_status": 0,
//	            "serial_id": "2S201507112200092743",
//	            "serial_type": 1,
//	            "title": "爸爸去哪儿第三季",
//	            "sub_title": "每周六12:00更新",
//	            "desc": "《爸爸去哪儿》第三季是湖南卫视2015年度第三季\r\n度推出的亲子户外真人秀节目。该节目由李锐担任主\r\n持，嘉宾由刘烨父子、邹市明父子、胡军父子、林永\r\n健父子、夏克立父女共五对明星爸爸及子女参加 。",
//	            "is_w": 0,
//	            "superscript": "",
//	            "cover": "http://img0.icartoons.cn/opftp/20150711/129803/201507112200092743/cover/web165x220.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&client_style=1",
//	            "pic": "http://img0.icartoons.cn/opftp/20150711/129803/201507112200092743/cover/720x405.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&client_style=1",
//	            "update_set": "8",
//	            "trackid": "144193462087532696eb757e02b6f42a-s-3--"
//	        },
//	        {
//	            "serial_status": "1",
//	            "serial_id": "2S201407012200090703",
//	            "serial_type": 1,
//	            "title": "爸爸去哪儿大电影",
//	            "sub_title": "明星亲子旅行生存体验",
//	            "desc": "一部父子亲情真人秀《爸爸去哪儿》，在中国掀起收视狂潮和广泛热议。明星爸爸们的舐犊情深，和萌娃们天真可爱的俏皮模样，给观众留下了深刻的印象。",
//	            "is_w": 0,
//	            "superscript": "",
//	            "cover": "http://img0.icartoons.cn/opftp/20140703/129803/201407012200090703/cover/web165x220.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&client_style=1",
//	            "pic": "http://img0.icartoons.cn/spftp/temp/2015050603104000000039513740/720x405.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&client_style=1",
//	            "update_set": "4",
//	            "trackid": "144193462087532696eb757e02b6f42a-s-3--"
//	        },
//	        {
//	            "serial_status": "1",
//	            "serial_id": "2S201406052200090502",
//	            "serial_type": 1,
//	            "title": "爸爸去哪儿 动画版",
//	            "sub_title": "萌宝姐姐",
//	            "desc": "该动画片根据热播综艺《爸爸去哪儿》改编，是与《村长趣哪鹅》真人秀栏目同属于《村长趣哪鹅》栏目下的板块节目，由著名动画导演“喜洋洋之父”黄伟明以及精英团队共同制作，加入了魔幻的色彩用创新的手法给小观众呈现了一幕幕爆笑、温馨、感人的画面，剧中还",
//	            "is_w": 0,
//	            "superscript": "",
//	            "cover": "http://img0.icartoons.cn/opftp/20140605/129803/201406052200090502/cover/web165x220.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&client_style=1",
//	            "pic": "http://img0.icartoons.cn/spftp/temp/2015080509332600000024413228/720x405.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&client_style=1",
//	            "update_set": "24",
//	            "trackid": "144193462087532696eb757e02b6f42a-s-3--"
//	        },
//	        {
//	            "serial_status": 0,
//	            "serial_id": "2S201406102200090511",
//	            "serial_type": 1,
//	            "title": "爸爸去哪儿-真人版",
//	            "sub_title": "",
//	            "desc": "每期五位明星爸爸跟子女72小时的乡村体验,爸爸单独肩负起照顾孩子饮食起居的责任,节目组设置一系列由父子共同完成的任务,父子俩在不熟悉的环境下状况百出。短短两天,将成为平日里很少有机会呆在一起的父子拉近距离的难忘时光。",
//	            "is_w": 0,
//	            "superscript": "",
//	            "cover": "http://img0.icartoons.cn/opftp/20140611/129803/201406102200090511/cover/web165x220.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&client_style=1",
//	            "pic": "http://img0.icartoons.cn/opftp/20140611/129803/201406102200090511/cover/720x405.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&client_style=1",
//	            "update_set": "12",
//	            "trackid": "144193462087532696eb757e02b6f42a-s-3--"
//	        },
//	        {
//	            "serial_status": "1",
//	            "serial_id": "2S201406222200090615",
//	            "serial_type": 1,
//	            "title": "爸爸去哪儿第二季",
//	            "sub_title": "人气小天后多多",
//	            "desc": "《爸爸去哪儿》 第2季正在热播，没有了风一样的女汉纸，没有嘴甜小胖妞，但是蜡笔小新一样的女纸和超甜美妞阵容非比寻常，爆点趣点层出不穷！想知道萌娃去哪闹翻天，星爸暗黑料理最新内幕？更多报道、超多花絮等你揭秘，火速围观！",
//	            "is_w": 0,
//	            "superscript": "",
//	            "cover": "http://img0.icartoons.cn/opftp/20140622/129803/201406222200090615/cover/web165x220.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&client_style=1",
//	            "pic": "http://img0.icartoons.cn/spftp/temp/2015013009190100000081913740/720x405.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&client_style=1",
//	            "update_set": "16",
//	            "trackid": "144193462087532696eb757e02b6f42a-s-3--"
//	        },
//	        {
//	            "serial_status": "1",
//	            "serial_id": "2S201503232200092237",
//	            "serial_type": 1,
//	            "title": "爸爸去哪儿2大电影",
//	            "sub_title": "终于上线啦！",
//	            "desc": "《爸爸去哪儿》第二季四组星爸萌娃原班人马即将整装待发，而这一次“终极任务”的目的地，将是风光旖旎的太平洋岛国——斐济，刚一到斐济上空，一个个不可思议的任务与挑战就开始了。",
//	            "is_w": 0,
//	            "superscript": "",
//	            "cover": "http://img0.icartoons.cn/opftp/20150324/129803/201503232200092237/cover/web165x220.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&client_style=1",
//	            "pic": "http://img0.icartoons.cn/spftp/temp/2015071701101400000013913228/720x405.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&client_style=1",
//	            "update_set": "4",
//	            "trackid": "144193462087532696eb757e02b6f42a-s-3--"
//	        }
//	    ]
//	}
/****************首页 api  结束*************/

}
