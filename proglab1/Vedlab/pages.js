let pages = new Map();

pages.set('main', 'main')

pages.set('reg', 'authorization/reg')
pages.set('login', 'authorization/login')
pages.set('account', 'account')

pages.set('lab1', 'lab1/lab_1')

pages.set('frontend', 'lab1/frontend/frontend')
pages.set('desc_frontend', 'lab1/frontend/desc_frontend' )

pages.set('datascience', 'lab1/datascience/datascience')
pages.set('desc_datascience', 'lab1/datascience/desc_datascience' )

pages.set('sysadmin', 'lab1/sysadmin/sysadmin')
pages.set('desc_sysadmin', 'lab1/sysadmin/desc_sysadmin' )

pages.set('testError', 'lab1/testError')
pages.set('stat', 'lab1/stat')

pages.set('tests', 'tests')
pages.set('all_tests', 'all_tests')

pages.set('pulse_start', 'pulse_start')
pages.set('pulse_after', 'pulse_after')

pages.set('tests_lab2', 'tests_lab2')
pages.set('tests_lab3', 'tests_lab3')
pages.set('tests_lab4', 'tests_lab4')
pages.set('tests_lab5', 'tests_lab5')
pages.set('easy_aud_test', 'tests_lab2/easy_aud_test')
pages.set('easy_aud_stat', 'tests_lab2/stat')
pages.set('easy_eye_test', 'tests_lab2/easy_eye_test')
pages.set('med_eye_test', 'tests_lab2/med_eye_test')
pages.set('hard_eye_test', 'tests_lab2/hard_eye_test')
pages.set('sum_aud_test', 'tests_lab2/sum_aud_test')
pages.set('sum_eye_test', 'tests_lab2/sum_eye_test')
pages.set('easy_moving_test', 'tests_lab3/easy_moving_test')
pages.set('hard_moving_test', 'tests_lab3/hard_moving_test')
pages.set('analog_tracking', 'tests_lab4/analog_tracking')
pages.set('tracking_with_persecution', 'tests_lab4/tracking_with_persecution')
pages.set('red_black_table', 'tests_lab5/red_black_table')
pages.set('landolt_ring', 'tests_lab5/landolt_ring')
pages.set('verbal_memory', 'tests_lab5/verbal_memory')
pages.set('visual_memory', 'tests_lab5/visual_memory')
pages.set('raven_test', 'tests_lab5/raven_test')
pages.set('voinarovsky_test', 'tests_lab5/voinarovsky_test')
pages.set('compasses_test', 'tests_lab5/compasses_test')

module.exports = {
    pagesMap: pages
}
