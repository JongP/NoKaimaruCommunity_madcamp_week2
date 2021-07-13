package com.example.madcamp_week2;

public class Restaurants {
    public static String[] rest_images = new String[]{
            "https://mblogthumb-phinf.pstatic.net/MjAxOTA0MjVfMTE3/MDAxNTU2MTU5MzA4NjI5.8F-sqIKiu9lWrdJt5ErJPdOQMVe_l_qo1P-5aNbeU3wg._c-AKqyw8r-E9qJvjy8eMOSQyECdk3aFjLzkUB33EDog.JPEG.doli1573/IMG_1115.jpg?type=w800",
            "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMDAzMjFfMjU1%2FMDAxNTg0Nzk3NzA5NTI2.i9HI5lz9iFkRecRhmtNwHXBZ--faMtzv8BCwruK6cVQg.-HdqaRHBUUze4Oei4dwlZaQOxg6WB-vIdAyO35Cs7QQg.JPEG.freedommath%2FIMG_5953.jpg&type=sc960_832",
            "https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=https%3A%2F%2Fmyplace-phinf.pstatic.net%2F20201207_186%2F1607321049271MTnfM_JPEG%2Fupload_955e1744e2f529b8abc2fda8e4ac78c0.jpeg",
            "https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=https%3A%2F%2Fmyplace-phinf.pstatic.net%2F20210603_173%2F1622689397917IXqO1_JPEG%2Fupload_2b4cecc42020e0062dd616d84c79d6da.jpeg",
            "https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=https%3A%2F%2Fmyplace-phinf.pstatic.net%2F20210510_244%2F1620631658367leyhn_JPEG%2Fupload_72ca70f92ea54351c355a24bb5b28ec2.jpeg",
            "https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTA2MjZfNzIg%2FMDAxNjI0NjkwMDk2MTQy.T7JBiGkb3odVF5lX2rZeK2Pipc3WzTiGuxQmf0amUVQg.xPSUxVToolKoHRr2dwlQg9yp-wg5RdiO8Z2dqK39VBgg.JPEG.bebeisadog%2Foutput_3433242373.jpg",
            "https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20170912_8%2F1505218998029G6WdR_JPEG%2F-jpZW5RzciRZfFrgst9zbMqM.jpg",
            "https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxOTAxMjBfMjU2%2FMDAxNTQ3OTE5ODAxMDUz.PPX2l8LXCs4wKiXk5vBJyZRlgumgJgYXbOe0FDkezi8g.8DMWKau92PSxffN5_ITfC7sXpvoCJX0Z10mHleJYeF8g.JPEG.mrp%2FPC193342.JPG",
            "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxNzAyMjdfMjA5%2FMDAxNDg4MTk1MzU1NDU1.RuH_ABacczoNVY2wa9MgJwTKE_XTvqxbQhMom65XKZcg.R8qvzxsdIM63ZN6jNd0Hud2GXLrEz0lszKdjYHr4PcYg.JPEG.botonssi%2FIMG_9337.JPG&type=sc960_832",
            "https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=https%3A%2F%2Fmyplace-phinf.pstatic.net%2F20210412_177%2F1618187731911YE1wG_JPEG%2Fupload_6cc00db088626b2a6ec4ebdbeedc1e8d.jpg",
            "https://mp-seoul-image-production-s3.mangoplate.com/1059196_1597576833651783.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=150",
            "https://mp-seoul-image-production-s3.mangoplate.com/37709/reviews/c7de4ea474bc.jpg",
            "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMDA4MzBfMjcg%2FMDAxNTk4NzY4MDk2MTUw.iHV0AruOTibZ8NxfQDYInjrPK8ppojTAiXt_HcTk2zEg.sQDLOPaRKhKAt3tQubMkcrh2ZBObXkyxGw_2gvobcgQg.JPEG.3124kds%2F1598767855774.jpg&type=sc960_832",
            "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTA0MTFfMjgy%2FMDAxNjE4MTQ4NzE1MDkx.bqPugZWI9hR1-v44Tk5OHi46-TsWkLhlLXI8KrzlG38g.t5_qPN5EU9mYuAj4SuOsj48U5XDDcGCXOA3difOgwhMg.JPEG.solee4507%2FIMG_4567.jpg&type=sc960_832",
            "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxOTA1MDNfMTg3%2FMDAxNTU2ODE3NDgxMDk3.kg-Z3UxXTGZx5UMuRohbx-3GMV-gzyZPX99oQzleIu8g.cqN4P7mlvDLcM4i_pKEVdE4ytnefiX4kKcrnEbwU0_Ig.JPEG.jisubaik1%2F1970-01-01_09.00.00_91.jpg&type=sc960_832",
            "https://gramho.com/hosted-by-instagram/url=https%3A%7C%7C%7C%7Cinstagram.fiev22-1.fna.fbcdn.net%7C%7Cv%7C%7Ct51.2885-15%7C%7Ce35%7C%7Cs1080x1080%7C%7C209047769_204105858271389_4910822798588719001_n.jpg%3Ftp%3D1%26_nc_ht%3Dinstagram.fiev22-1.fna.fbcdn.net%26_nc_cat%3D109%26_nc_ohc%3DhWqilcUbI-oAX87LRie%26edm%3DAABBvjUBAAAA%26ccb%3D7-4%26oh%3D35eb6d5e62998b8cee0c87a24d60008e%26oe%3D60E90ED3%26_nc_sid%3D83d603",
            "https://mp-seoul-image-production-s3.mangoplate.com/254855/407456_1468386764775_58875",
            "https://search.pstatic.net/sunny/?src=https%3A%2F%2Fmp-seoul-image-production-s3.mangoplate.com%2F478541_1517110224414897.jpg%3Ffit%3Daround%257C512%3A512%26crop%3D512%3A512%3B*%2C*%26output-format%3Djpg%26output-quality%3D80&type=sc960_832",
            "https://mblogthumb-phinf.pstatic.net/MjAxNzAyMTNfMjYy/MDAxNDg2OTcyNzU3MjU0.mN2r0QTXlrRyk59D6aSJfSsLwO2tKU9l4P8vKlI6IDQg.AmT6goTGx5EI-xMNxt4QDDAfF3wxXE--oMpk3mVnGmog.JPEG.ssunypd/IMG_5787.jpg?type=w800",
            "https://mblogthumb-phinf.pstatic.net/MjAyMTAxMTRfMTc1/MDAxNjEwNTk2MzQyNTE4.QhB3z8XahfFnbw_POYg3JanLCA6bv1k5AlIfiEXw1sQg.Eh81fBQ6d_F3-tDJcch5g_kNVlV8Q5G-8SonFtulmf0g.JPEG.limhr51/KakaoTalk_20210114_074436814.jpg?type=w800"
    };

    public static String[][] detail_images = new String[][]{
            // 세번째 우물
            {
                    "https://mblogthumb-phinf.pstatic.net/MjAxOTA0MjVfMTE3/MDAxNTU2MTU5MzA4NjI5.8F-sqIKiu9lWrdJt5ErJPdOQMVe_l_qo1P-5aNbeU3wg._c-AKqyw8r-E9qJvjy8eMOSQyECdk3aFjLzkUB33EDog.JPEG.doli1573/IMG_1115.jpg?type=w800",
                    "https://mp-seoul-image-production-s3.mangoplate.com/added_restaurants/47875_1490970601070435.jpg",
                    "https://lh3.googleusercontent.com/proxy/MjdXQy1oJ5Ozw4fxipy2jlvcywzK48oktpZl-nfcW_tyBDOyuEX61O1gRurPwzL452vGsUHcTPEV2MJUz-4GN-WkmSy77zjDhFcoy0RvtgY-J2c6XvICxzDOVsTKC0yjGYmL9DFtS1oe17rwZnea4t4-iQ",
                    "https://lh3.googleusercontent.com/proxy/hXjg537aktqqB8qULEcJzhKA1d8-Cfcw9nqVGUAjCDetusgK0BgEwX6oJvZDHnJIGhJAMfdgaFByRx8I3qkYEhhj3KWkdznZroT1NjhhO_w1OAFAA7OSI_iajBiELrkriFMXf0Vg2OJLwOAvsWwm-0KUCA",
            },
            // 어랑족
            {
                    "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMDAzMjFfMjU1%2FMDAxNTg0Nzk3NzA5NTI2.i9HI5lz9iFkRecRhmtNwHXBZ--faMtzv8BCwruK6cVQg.-HdqaRHBUUze4Oei4dwlZaQOxg6WB-vIdAyO35Cs7QQg.JPEG.freedommath%2FIMG_5953.jpg&type=sc960_832",
                    "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxNzA1MDhfMTcx%2FMDAxNDk0MjIxNzIyMjcx.vIJytvUfqBiBh_tBlUJx7ob1-0PtPVy1Idsga1BYcnUg.zNkE0Z3xYlkRX2Qb9Ut2ecVnYCWlX2sPZVWV9x_YvDAg.JPEG.crew_kw%2FIMG_1977.JPG&type=sc960_832",
                    "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMDAxMDJfMjg0%2FMDAxNTc3ODkzMjk0Nzc4.Vqnr_4eSikl-ZLmiadRFmvyOVWKHGCbk-h6xbkrEjzcg.AgxwUsaHxApqcAdb3YZvDwvCsZtn9gTQfBGsGw_ZMwUg.JPEG.ekdus8599%2FIMG_1975.jpg&type=sc960_832",
            },
            // 골목
            {
                    "https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=https%3A%2F%2Fmyplace-phinf.pstatic.net%2F20201207_186%2F1607321049271MTnfM_JPEG%2Fupload_955e1744e2f529b8abc2fda8e4ac78c0.jpeg",
                    "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTA0MjlfMjQw%2FMDAxNjE5Njc1MDQyNDQ3.psEUY2oHxmPx7oNhqta-PSRmFuC4MAknJllmN6mZfO4g.VtsLylNRGKaRAdukVn3FaKaRSpPsj4f9ujyBT0-vXz4g.JPEG.qbdnjs35%2F24221F65-A30C-404F-B6DE-69D307FC9883.jpeg&type=sc960_832",
                    "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTA3MDFfMTIy%2FMDAxNjI1MTQ2MTg1NzQ4.DGhe6SoiZ6i8G62t_WhwFyA4cXJRY9rngnm8mgi-iFog.ZVvqzDPDFxTXKPunhufbco1TR-Jv6T_07nF4Zk6u2aUg.JPEG.krkim7968%2F20210601%25A3%25DF190638.jpg&type=sc960_832",
                    "https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20210523_186%2F1621737637050PKQjc_JPEG%2FHnafiN27_d6eRnehu311y7Bw.jpg\n",
            },
            // 달구지 막창
            {
                    "https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=https%3A%2F%2Fmyplace-phinf.pstatic.net%2F20210603_173%2F1622689397917IXqO1_JPEG%2Fupload_2b4cecc42020e0062dd616d84c79d6da.jpeg ",
                    "https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMDA3MzBfMjc4%2FMDAxNTk2MDgzMDk3Mzkw.5YYLbYUyP-_6oCucMYuqvKWCVPyF5ClSbZRCxL1veNYg.DbZMg_y0eeddGSsOl6Nc1AJ9HK25yTomgHG3AmrvRJUg.JPEG.letmechangeu%2FIMG_6400.JPG",
                    "https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMDA5MzBfMTcz%2FMDAxNjAxNDYxNzU4MTQ3.-YUgBvTGLyHBEwPrpyGdHxQlNcM8zLfY3ud16SCQveEg.a0eRa2xSAfY-qmP3lUbXidYSwQVUIgPW-15zglSB4HEg.JPEG.wlals5970%2FKakaoTalk_20200925_141003000.jpg",
                    "https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTA2MjBfMjYg%2FMDAxNjI0MTk1MTA1NTMx.Bpq6__LeMJ00I8Tb-HJiFCCup4t_vxn22-rsN5ocKOcg.0CBYIw1M6XqKAYMl-GIwVeNsmiJ_rLgm38yKAWVEnKAg.JPEG.ainsinboo%2FKakaoTalk_20210620_215556192.jpg",
            },
            // 요시다
            {
                    "https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=https%3A%2F%2Fmyplace-phinf.pstatic.net%2F20210510_244%2F1620631658367leyhn_JPEG%2Fupload_72ca70f92ea54351c355a24bb5b28ec2.jpeg",
                    "https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=https%3A%2F%2Fmyplace-phinf.pstatic.net%2F20200516_266%2F1589617020765yRhvG_JPEG%2Fupload_0bdefe428ef36535b04083769bed95a5.jpg",
                    "https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTAzMjBfMTYy%2FMDAxNjE2MjA5ODY0MTc1.8pmpSSJaJOehvwK_mP72NFsjE-tUWW0NXbFYSw3qAK8g.o0CTGdW-BB0Ebn9yOo_WwopE3d7N9cVDTfI61rz2tjog.JPEG.dydynana%2F1616209835135.jpg",
                    "https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20190324_63%2F1553413695437yRiOD_JPEG%2FTy3XlocCsCJ9yaE7tMuTdEcr.JPG.jpg",
            },
            // 마쯔미
            {
                    "https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTA2MjZfNzIg%2FMDAxNjI0NjkwMDk2MTQy.T7JBiGkb3odVF5lX2rZeK2Pipc3WzTiGuxQmf0amUVQg.xPSUxVToolKoHRr2dwlQg9yp-wg5RdiO8Z2dqK39VBgg.JPEG.bebeisadog%2Foutput_3433242373.jpg",
                    "https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=https%3A%2F%2Fmyplace-phinf.pstatic.net%2F20200129_65%2F1580303894395zQnf6_JPEG%2Fupload_8b2859c3cbeba7ce5d66ec3dbe920c2b.jpg",
                    "https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTA2MDZfMTE0%2FMDAxNjIyOTE4MzQxMDE3.IYRcYQORDbVHm_fWXQYr2t_IKMz79OUncRTF59VqBWUg.kEkpagSjDd5bvGX8Sr3X4gSvojDvr11mWyIM-oYmTJQg.JPEG.bebeisadog%2FIMG_0641_jpg.jpg",
                    "https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxNzA4MDRfMTk1%2FMDAxNTAxODM5OTQ3NDI5.Pd5hb5vNTo3meB-2vxvhusQ98WfjlVLGxXH_Df2RSZYg.izDwvSfWpoEghTWoS0mk3H2jZ7VkkQQyigSsFWAURrIg.JPEG.ujam%2FKakaoTalk_20170804_181512620.jpg",
                    "https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxNzA5MDRfMTIw%2FMDAxNTA0NTIwNjE5MjQx.G3EcuwH-E7N1hJsHt9X4LGkpMFe6YG_N2XDy5XUUsJkg.w9Lmg-BeqEanXMGwK8oc8L4MeyMFIsNpqOTURKQ0ywkg.JPEG.kamojambo78%2F2017-09-04-19-12-32.jpg",
            },
            // 하레
            {
                    "https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20170912_8%2F1505218998029G6WdR_JPEG%2F-jpZW5RzciRZfFrgst9zbMqM.jpg",
                    "https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMDA5MDZfNTgg%2FMDAxNTk5MzYxOTk1NjA4.NIt59vsl-yJGgl4cA5w02RNKS15i4Pfh8EpAQYaqas8g.cgiobY82rINCf_dxGH4E5v49kEsRo1gYpziIZpX6v8cg.JPEG.leisamy%2FIMG_1365.JPG",
                    "https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTA1MjdfMTE2%2FMDAxNjIyMDgxMTQ1OTk3.nFGYIbeXopUOXYrqFfd9dNpnZAk-eBs46DPmqf2bkm4g.UeJbpmRofEN3pn2N6YJvjWzOoei2cqMTcW89v9BXy2cg.JPEG.onmomhani%2FIMG_6081.jpg",
                    "https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=https%3A%2F%2Fmyplace-phinf.pstatic.net%2F20200503_95%2F1588436799425Jg2BK_JPEG%2Fupload_d06c994d60e0a0c9ac47817bafbfb291.jpg",
                    "https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20170912_250%2F15052189270871STWt_JPEG%2F8KPhNtVchCx1BgqcTjqAD0xJ.jpg",
            },
            // 기시맹
            {
                    "https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxOTAxMjBfMjU2%2FMDAxNTQ3OTE5ODAxMDUz.PPX2l8LXCs4wKiXk5vBJyZRlgumgJgYXbOe0FDkezi8g.8DMWKau92PSxffN5_ITfC7sXpvoCJX0Z10mHleJYeF8g.JPEG.mrp%2FPC193342.JPG",
                    "https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxOTAxMjBfNiAg%2FMDAxNTQ3OTE5Nzg5OTMy.zp1UzX5eHnXudKaCMUlxc9JIb61q_No2u8aPd1yY-O8g.l8coBr1DVzrxTjrIc2O1agAbW3EhX8uaNs1aBkSHrX4g.JPEG.mrp%2FPC193339.JPG",
                    "https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxOTA0MjVfOTUg%2FMDAxNTU2MTU5OTQ1Njcy.9HllXnzZD2BnOlYqlCFi-LIGl-gkfsh-JEOsR3dNzTIg.s-5f0tbLVT4r5LH50LuiZFcJJ7farqOptNP6jDGkqtUg.JPEG.doli1573%2FIMG_1173.jpg",
                    "https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxOTA0MjVfMzAw%2FMDAxNTU2MTU5OTQ1MTMx.0xGYbW2gLhmgmXwu7UoePZICq0zzmANlJHTjcxXzea0g.xhUpNGrV9mNVwsXOI5AmddbXVhgz7J2Qcv3YjBvLFcMg.JPEG.doli1573%2FIMG_1170.JPG",
                    "https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxNzA0MTZfMjM1%2FMDAxNDkyMzI2MjkyMTU0.echL7rIo0NZ5LFlkqbBjb9MrfwVajo1vH9CDvzcOcCYg.nuctppqX0W-QQl_nCYnNaWGz7miW18XVmxoXaEpxiiog.JPEG.puuyoo%2Fd0597dcc-e840-4b65-ad19-d793f67065a2.jpg",
            },
            // 111-7
            {
                    "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxNzAyMjdfMjA5%2FMDAxNDg4MTk1MzU1NDU1.RuH_ABacczoNVY2wa9MgJwTKE_XTvqxbQhMom65XKZcg.R8qvzxsdIM63ZN6jNd0Hud2GXLrEz0lszKdjYHr4PcYg.JPEG.botonssi%2FIMG_9337.JPG&type=sc960_832",
                    "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxOTA3MDlfMTMx%2FMDAxNTYyNjYxMDA4NzY1._F93unPFTtCwt2FPuWuq9gnU9XwclWEnSjuHl0GBDTcg.9My4yMKX73Ax8IMVhZWlxmJxovZ4Nve3IDHnzndBaK8g.JPEG.isyw0203%2FIMG_5686.jpg&type=sc960_832",
                    "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxODAxMjJfMjYx%2FMDAxNTE2NTk4OTkyOTQ0.UoezAilNmQuHnyatbniib7SG4XzuITIruaO7hg928xMg.5He2QrzSdOBa2PI7k2hI-eSte4z38I5WIOP52PPWsRog.JPEG.sjtsl%2FattachImage_3777522995.jpeg&type=sc960_832",
                    "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTAxMDJfMTQ2%2FMDAxNjA5NTUzMjg3MjE3.8O9gJgTEByXTht3oJ1qfaONBP58Z1hG_pG8RZH16hMEg.qc5-E5jdc0f-oYwpzp-seFqDDGuZGUHUsn750JAUhiEg.JPEG.dkdud5722%2FKakaoTalk_20210102_105313817_12.jpg&type=sc960_832",
                    "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2F20150623_87%2Fdaejeonnom_1435039048864KKjdF_JPEG%2F%25B1%25D7%25B8%25B28.jpg&type=sc960_832",
            },
            // 베리신주쿠
            {
                    "https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=https%3A%2F%2Fmyplace-phinf.pstatic.net%2F20210412_177%2F1618187731911YE1wG_JPEG%2Fupload_6cc00db088626b2a6ec4ebdbeedc1e8d.jpg",
                    "https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTA0MzBfMzYg%2FMDAxNjE5NzQ2ODEzMTU1.8ASMeDiT6WFiIsOXhKFzBDxTLZt_KVBsxHKcbsQmttIg.Pyr0npSZyt081jSD6YDLh5rw7KrAMc8Gg0FARxEH7cgg.JPEG.kiju134%2FP20210429_120729966_04F9B91E-792A-437D-9F9B-786D63FB1EF3.jpg",
                    "https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=https%3A%2F%2Fmyplace-phinf.pstatic.net%2F20210309_233%2F161527074872221RgA_JPEG%2Fupload_47853d388be3f0ab0bbeb28bf4cbb8ac.jpg",
                    "https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20190118_190%2F1547794386437yJ5A0_JPEG%2FUVzuRgW-zTyurRNGWVmYpoAB.jpg",
            },
            // 겐스시
            {
                    "https://mp-seoul-image-production-s3.mangoplate.com/1059196_1597576833651783.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=150",
                    "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2F20160106_59%2Frladudtls222_1452067150825xbc4s_JPEG%2FIMG_9897.jpg&type=sc960_832",
                    "https://mblogthumb-phinf.pstatic.net/MjAxOTA0MThfMjEg/MDAxNTU1NTcxNDI4OTEy.wRaXCnKpekQIk3jOb_WTHL4_5D-_p8bHVqzenVUPDIwg.jaC2w6iQlreihXKQAowLNYCP-I4dnytazE5NdKyi9vwg.JPEG.cil8495/SE-529fbc1d-484e-4eee-b717-832042815f83.jpg?type=w800",
            },
            // 란스시
            {
                    "https://mp-seoul-image-production-s3.mangoplate.com/37709/reviews/c7de4ea474bc.jpg",
                    "https://img1.daumcdn.net/thumb/R720x0.q80/?scode=mtistory2&fname=http%3A%2F%2Fcfile8.uf.tistory.com%2Fimage%2F2631BB455858E8DC386CCB",
                    "https://t1.daumcdn.net/cfile/tistory/2725B74751B8171A37",
            },
            // 어은스시
            {
                    "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMDA4MzBfMjcg%2FMDAxNTk4NzY4MDk2MTUw.iHV0AruOTibZ8NxfQDYInjrPK8ppojTAiXt_HcTk2zEg.sQDLOPaRKhKAt3tQubMkcrh2ZBObXkyxGw_2gvobcgQg.JPEG.3124kds%2F1598767855774.jpg&type=sc960_832",
                    "https://pbs.twimg.com/media/ES55WxcU0AEFerc.jpg",
                    "https://modo-phinf.pstatic.net/20150823_20/1440256330212sjYxC_JPEG/mosaPOLTC9.jpeg?type=w720",
            },
            // 우디룸
            {
                    "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTA0MTFfMjgy%2FMDAxNjE4MTQ4NzE1MDkx.bqPugZWI9hR1-v44Tk5OHi46-TsWkLhlLXI8KrzlG38g.t5_qPN5EU9mYuAj4SuOsj48U5XDDcGCXOA3difOgwhMg.JPEG.solee4507%2FIMG_4567.jpg&type=sc960_832",
                    "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTA0MDRfNzUg%2FMDAxNjE3NTQ1ODkwODIy.ndzkD0uahWNKKKr3anNwtKBAM0FhEmr6tnFIRPEmnNkg.ya0TlNiOEJmi25DrrQfVSzY8y3ky4cGK2Lh35FUk7k4g.JPEG.wks1101%2F47ED53A8-5EBD-4605-8B40-534EA3703D58.jpg&type=sc960_832",
                    "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTA0MDlfMTIx%2FMDAxNjE3OTQ3MDk3NDY4.oIliDOnncD4_4CW9Q7tnTmFqjJTqU4iF1Da97nMshDEg.85HYj5HPMlr7aJBG6iBQQi9P0_jJF-YWnn_38LDOyl4g.JPEG.juvigre%2F20210409%25A3%25DF114836.jpg&type=sc960_832",
                    "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTAyMTRfMjY4%2FMDAxNjEzMjU4NjYzMTc4.bt8lGJxYSxw1o9WJareGfuMLVb5B4-cruQZlLHZFci8g.LzMhcPOhWs5nYwhBYBDiqsAd4yYNeKkhkoV8UwT60W4g.JPEG.hyunjiii1114%2FIMG_4306.jpg&type=sc960_832",
                    "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTA0MjRfMjI4%2FMDAxNjE5MjYxNTEzODU1.tvVwD0nisyGjVENmE1IRdrZx4lUnxltu0T7euJP1ISIg.gTCzstLbac4RRqUzDs1TxWfoKl3q8ywnCK-Qk-HSWeQg.JPEG.view8525%2FIMG_4924.jpg&type=sc960_832",
                    "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTA0MjBfMjE2%2FMDAxNjE4ODkxMzQ2MzAx.ziI3f6I-xa4Sf_WsyiXeECppQvpt66r8dBZzBB-BpKYg.xwcJ7xZSQ5I_DUHntuM_9cmwK-cuvRAE3IIAnq9qon0g.JPEG.luckyjjjin%2F20210410%25A3%25DF112827.jpg&type=sc960_832",
                    "https://blog.kakaocdn.net/dn/dJx3bZ/btq5G2ZyK4d/3331IIogIBfJ40ziNjr4u1/img.jpg",
                    "https://mblogthumb-phinf.pstatic.net/MjAyMTAyMjVfMjUz/MDAxNjE0MjYyMzY2MTYx.EpbKblWfT_lc789h4YhfT8zVGSR60CAGWSp4t4gI7bgg.Duo2dTsNTbolPOjN8K1dWsApIQkc4iGEPkvbE7oTt50g.JPEG.yuseonggu/IMG_0524_copy.jpg?type=w800",
            },
            // 아카바
            {
                    "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxOTA1MDNfMTg3%2FMDAxNTU2ODE3NDgxMDk3.kg-Z3UxXTGZx5UMuRohbx-3GMV-gzyZPX99oQzleIu8g.cqN4P7mlvDLcM4i_pKEVdE4ytnefiX4kKcrnEbwU0_Ig.JPEG.jisubaik1%2F1970-01-01_09.00.00_91.jpg&type=sc960_832",
                    "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxODA5MjlfNTIg%2FMDAxNTM4MTg2Mjc0NzQw.MyIMg2lN_Qh4PCjqZwCeAypBPr5r1koK1TriKV2tNqgg.nga1EKKJoUvIwVd1Xg6bGJ2k_a6M2Zlnwls7vDuHJzEg.JPEG.choyl1998%2FP20180809_174925715_63262666-F691-4752-8E66-06DD28350963.jpg&type=sc960_832",
                    "https://mp-seoul-image-production-s3.mangoplate.com/37208_1621267208414804.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=200",
                    "https://mp-seoul-image-production-s3.mangoplate.com/574886_1623778191033944.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=200",
                    "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMDA3MjRfMTIy%2FMDAxNTk1NTY3NjA2NzIz.EzeDLXn4l9G8oLf7Pgjoi3nbIMGeId9o59j-_ciX0Uwg.LsT_8kVKlzOnV11HC6HU-5B6ewjuLts9jUptVXzUesEg.JPEG.goodyjegood%2F%25B4%25EB%25C0%25FC%25C0%25AF%25BC%25BA%25B1%25B8%25B8%25C0%25C1%25FD%25C3%25DF%25C3%25B5.jpg&type=sc960_832",
                    "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTA0MDNfOTkg%2FMDAxNjE3Mzc3Njg4NDU1.5mOGPYIaL-w7_bY27AWZf3TQKIzVn503KaTVR7JZi8Qg.HAleCJdff0XD4mpZa26gRsWnCQajhWADQhQFk3sp2Kgg.JPEG.tobehappy2021%2FKakaoTalk_20210403_003124853.jpg&type=sc960_832",
            },
            // 잇마이타이
            {
                    "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTA2MjFfMTYw%2FMDAxNjI0MjAzMDY1ODg5.kES7__VhramLHODpbVZbliRYdGj46EiZgaQxOZJ-n2Qg.ZKQY0cPdx9ZGDhgufu78auwSLN_AtkoZIU2uIviYKXQg.JPEG.jse9608%2Foutput_2051077282.jpg&type=sc960_832",
                    "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTA1MjBfNDUg%2FMDAxNjIxNTIyNTkwODY4.ZFm5iBi8ayKUXUxz2zpKok8UsVgn4-juTOhqt8qkkugg.rmWj3g1O3ejb8yRebcbNuKBpyDcM-rHW4MGsDaWdRp8g.JPEG.b5951%2F20210519%25A3%25DF171349.jpg&type=sc960_832",
                    "https://gramho.com/hosted-by-instagram/url=https%3A%7C%7C%7C%7Cinstagram.fiev22-1.fna.fbcdn.net%7C%7Cv%7C%7Ct51.2885-15%7C%7Ce35%7C%7Cs1080x1080%7C%7C209047769_204105858271389_4910822798588719001_n.jpg%3Ftp%3D1%26_nc_ht%3Dinstagram.fiev22-1.fna.fbcdn.net%26_nc_cat%3D109%26_nc_ohc%3DhWqilcUbI-oAX87LRie%26edm%3DAABBvjUBAAAA%26ccb%3D7-4%26oh%3D35eb6d5e62998b8cee0c87a24d60008e%26oe%3D60E90ED3%26_nc_sid%3D83d603",
                    "https://www.picuki.com/hosted-by-instagram/url=https%3A%7C%7C%7C%7Cinstagram.fiev22-1.fna.fbcdn.net%7C%7Cv%7C%7Ct51.2885-15%7C%7Ce35%7C%7Cp1080x1080%7C%7C204102571_896010740982389_3800476018425309746_n.jpg%3Ftp%3D1%26_nc_ht%3Dinstagram.fiev22-1.fna.fbcdn.net%26_nc_cat%3D105%26_nc_ohc%3D9v08tg9T7JkAX_ZJK_l%26edm%3DAABBvjUBAAAA%26ccb%3D7-4%26oh%3D26806967693d86fcab1d55b107f57a04%26oe%3D60E9C170%26_nc_sid%3D83d603",
                    "https://www.picuki.com/hosted-by-instagram/url=https%3A%7C%7C%7C%7Cinstagram.fiev22-1.fna.fbcdn.net%7C%7Cv%7C%7Ct51.2885-15%7C%7Ce35%7C%7Cs1080x1080%7C%7C209925122_532910921194431_241808277031469222_n.jpg%3Ftp%3D1%26_nc_ht%3Dinstagram.fiev22-1.fna.fbcdn.net%26_nc_cat%3D103%26_nc_ohc%3DNoillqvgioAAX8dWewT%26edm%3DAABBvjUBAAAA%26ccb%3D7-4%26oh%3D9e9d2ceccce834271bd12c1cab4b9625%26oe%3D60E92B86%26_nc_sid%3D83d603",
            },
            // 맑음
            {
                    "https://mp-seoul-image-production-s3.mangoplate.com/254855/407456_1468386764775_58875",
                    "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMDEyMDNfMjEx%2FMDAxNjA2OTgxNjk5MzM5.8nGwje4skjYoLh4FNSKUXYUM2kOJav0sA1PtkPJ3CPQg.9UMRbPW98245nJqiecv63WW4MfrbEqQfrqstB0Di1ZAg.JPEG.choi-1123%2F20201127%25A3%25DF175149.jpg&type=sc960_832",
                    "https://mp-seoul-image-production-s3.mangoplate.com/37208_1596436137685062.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=200",
                    "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMDEyMzBfMjk5%2FMDAxNjA5Mjk1NDY4Njg1.HlBQC0V4az-7A0Uhk7BPnaOvOI3I8NDMqyQWtI-v03Yg.mABwKKzFOiZRe5JWtquaLn1FYd0I22TayXDrOIU8MbYg.JPEG.kimyubin4312%2FDSC00611.JPG&type=sc960_832",

            },
            // 더자니펍
            {
                    "https://search.pstatic.net/sunny/?src=https%3A%2F%2Fmp-seoul-image-production-s3.mangoplate.com%2F478541_1517110224414897.jpg%3Ffit%3Daround%257C512%3A512%26crop%3D512%3A512%3B*%2C*%26output-format%3Djpg%26output-quality%3D80&type=sc960_832",
                    "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxNjEyMTFfOTMg%2FMDAxNDgxNDU3MzA2MzI4.wEBkOxDDS_UlHab9jBTQFJdfR2zHi_p6neTEO2SC7Hog.l4nlentonbRyCqmfvibTkJuLPdY2AXlZ9gf7vbhQp5og.JPEG.junging126%2FIMG_3650.JPG&type=sc960_832",
                    "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxOTAyMTFfMjgg%2FMDAxNTQ5ODE4MTYxNzA1.w_ewCCPANDHsJsB5TnHtfIXwrdflOwsbA2zkALKSeO0g.L1d_rcsQvJX2BihOI207ARqE94FKLen78nCuk5YNlZgg.JPEG.dlgldlg123%2FKakaoTalk_20190201_204738852_03.jpg&type=sc960_832",
                    "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxOTAyMTFfMjQy%2FMDAxNTQ5ODE4MTcyNjQw.0JTO6gD2F-VfbAr03AYYXoO_59368xxVnk4ANIviP34g.bDe8IM1g4H8JKHT25mAPDq6eYqGjgb-vsbwtDyQfsL8g.JPEG.dlgldlg123%2FKakaoTalk_20190201_204738852_04.jpg&type=sc960_832",
                    "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxODA1MTdfODQg%2FMDAxNTI2NTM3MTE4NDI0.YP48PYa52L7sbzgZ-Kq4gBspTHBHkDtBh-mVbNSUiSwg.GtqpZa1I-q9MzXTrUzH35Ini-eLjbIrRRnfRdvkNm3wg.JPEG.leah8337%2F7650962144_IMG_6846.jpg&type=sc960_832",
            },
            // 55와인포차
            {
                    "https://mblogthumb-phinf.pstatic.net/MjAxNzAyMTNfMjYy/MDAxNDg2OTcyNzU3MjU0.mN2r0QTXlrRyk59D6aSJfSsLwO2tKU9l4P8vKlI6IDQg.AmT6goTGx5EI-xMNxt4QDDAfF3wxXE--oMpk3mVnGmog.JPEG.ssunypd/IMG_5787.jpg?type=w800",
                    "https://scontent.ficn2-1.fna.fbcdn.net/v/t31.18172-8/p843x403/17807355_1853475004926175_7974529217210042388_o.jpg?_nc_cat=110&ccb=1-3&_nc_sid=9267fe&_nc_ohc=G_vn3I47qAQAX8qXXxP&_nc_ht=scontent.ficn2-1.fna&tp=6&oh=97ed9b30a6b389e9a80d3fa14d3e1626&oe=60E7BC46",
                    "https://gramho.com/hosted-by-instagram/url=https%3A%7C%7C%7C%7Cinstagram.fiev22-1.fna.fbcdn.net%7C%7Cv%7C%7Ct51.2885-15%7C%7Ce35%7C%7Cs1080x1080%7C%7C118401009_304905394137187_1409253785170765435_n.jpg%3Ftp%3D1%26_nc_ht%3Dinstagram.fiev22-1.fna.fbcdn.net%26_nc_cat%3D107%26_nc_ohc%3Dmvmie-qEOtIAX9r78CA%26edm%3DAA0rjkIBAAAA%26ccb%3D7-4%26oh%3D9b35950abeb0b2e9923c115b28fdc6c3%26oe%3D60E94CCE%26_nc_sid%3Dd997c6",
                    "https://gramho.com/hosted-by-instagram/url=https%3A%7C%7C%7C%7Cinstagram.flwo4-1.fna.fbcdn.net%7C%7Cv%7C%7Ct51.2885-15%7C%7Ce35%7C%7Cp1080x1080%7C%7C52344953_964081497134323_6098269435165245962_n.jpg%3Ftp%3D1%26_nc_ht%3Dinstagram.flwo4-1.fna.fbcdn.net%26_nc_cat%3D107%26_nc_ohc%3DWM5yHanDKEsAX--KFN2%26edm%3DAABBvjUBAAAA%26ccb%3D7-4%26oh%3Dbc5c77e83e76481de30a90180f343471%26oe%3D60EA171C%26_nc_sid%3D83d603",
                    "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTA2MDdfMTUx%2FMDAxNjIzMDM2NDQwNDEx.4oBbruJtJONgEwp-VXSykmzlQM2DkegMOOmRBfDUFXgg.19j1VTsj_ckTWhMyMUGlNIROcQ9koXMOA5RHpKvaXQkg.JPEG.dkssud308%2FIMG_6772.JPG&type=sc960_832",
                    "https://gramho.com/hosted-by-instagram/url=https%3A%7C%7C%7C%7Cinstagram.fiev22-2.fna.fbcdn.net%7C%7Cv%7C%7Ct51.2885-15%7C%7Ce35%7C%7C69616937_182531509444621_8141407151881363490_n.jpg%3Ftp%3D1%26_nc_ht%3Dinstagram.fiev22-2.fna.fbcdn.net%26_nc_cat%3D101%26_nc_ohc%3D8Yt6FScm84AAX-mn1la%26edm%3DAABBvjUBAAAA%26ccb%3D7-4%26oh%3D5d842bfd582baa258da32887424cb8fd%26oe%3D60E95C4D%26_nc_sid%3D83d603",
            },
            // 글루글루
            {
                    "https://mblogthumb-phinf.pstatic.net/MjAyMTAxMTRfMTc1/MDAxNjEwNTk2MzQyNTE4.QhB3z8XahfFnbw_POYg3JanLCA6bv1k5AlIfiEXw1sQg.Eh81fBQ6d_F3-tDJcch5g_kNVlV8Q5G-8SonFtulmf0g.JPEG.limhr51/KakaoTalk_20210114_074436814.jpg?type=w800",
                    "https://mblogthumb-phinf.pstatic.net/MjAyMDA3MDdfMTcy/MDAxNTk0MDUxMDA1NTM3.ApNtTqe8rOH6Z0vFfbVE9sKbAsGSlovj4PXomzUIxWsg.0CiqlwdeTHRcTdiH6Ptk8xGd6rZ7VolNZWEb66B8gscg.JPEG.cheolheelee9/SE-ef41d5ce-5f2c-41e9-b76c-8a44409957bb.jpg?type=w800",
                    "https://mblogthumb-phinf.pstatic.net/MjAyMDA3MDFfMjAy/MDAxNTkzNTkxNjY3Mjkw.yVgjCnRqXqe3hFd32NohRqRgAHtK76YqMFewl-BCvwEg._Y5gm-DIUOOGl7877RrMMXWPbCTBDaeeqfojs_smtm4g.JPEG.cheolheelee9/DSC09890.JPG?type=w800",
                    "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMDA4MjJfMTAg%2FMDAxNTk4MDgxMTY5OTg2.s9yTydqJd7H3Z1PS82GfklAfuGKh4HKQW3VhvYh_Z10g.MbVUTng8XwsLp_ZaZGJkJxeLFGQ29EGpqre_o53jIuwg.JPEG.rim5537%2FKakaoTalk_20200822_144046362_21.jpg&type=sc960_832",
                    "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTAzMjNfMTA3%2FMDAxNjE2NTAzMjIyMDg4.IFzUc0bn-_lBZ7AhO4ZFRega6XwMKn1Vi0BfG5ov70Ug.9eVqBg-Kttr988edvL64Cp7eyjnRDXOxI5IHap19nisg.JPEG.efsnt4624%2FKakaoTalk_20210323_213139657_07.jpg&type=sc960_832",
                    "https://mp-seoul-image-production-s3.mangoplate.com/1825649_1616728813380499.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=200",
                    "https://mp-seoul-image-production-s3.mangoplate.com/1332386_1597831487264538.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=200",
                    "https://mp-seoul-image-production-s3.mangoplate.com/1825649_1616728814450178.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=200",

            },
    };
}
